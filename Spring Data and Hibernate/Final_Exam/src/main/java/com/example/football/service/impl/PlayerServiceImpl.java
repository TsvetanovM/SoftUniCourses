package com.example.football.service.impl;

import com.example.football.models.dto.PlayerImport;
import com.example.football.models.dto.PlayersImport;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static final String PLAYERS_XML_INPUT_PATH = "./src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final StatRepository statRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validator;

    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository, TownRepository townRepository, StatRepository statRepository, ModelMapper mapper, ValidationUtil validator) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.statRepository = statRepository;
        this.mapper = mapper;
        this.validator = validator;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws FileNotFoundException {
        try {
            return Files.readString(Path.of(PLAYERS_XML_INPUT_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new FileNotFoundException();
    }

    @Override
    public String importPlayers()  {
        StringBuilder output = new StringBuilder();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PlayersImport.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            PlayersImport playersImport = (PlayersImport) unmarshaller.unmarshal(new FileReader(PLAYERS_XML_INPUT_PATH));

            for (PlayerImport playerImport : playersImport.getPlayers()) {
                if (playerRepository.existsByEmail(playerImport.getEmail())
                        || !validator.isValid(playerImport)) {
                    output.append("Invalid Player").append(System.lineSeparator());
                    continue;
                }
                Player player = mapper.map(playerImport, Player.class);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                player.setStat(statRepository.findById(playerImport.getStat().getId()).orElse(null));
                player.setTeam(teamRepository.findByName(playerImport.getTeam().getName()));
                player.setTown(townRepository.findByName(playerImport.getTown().getName()));
                playerRepository.save(player);
                output.append(String.format("Successfully imported Player %s %s - %s%n",
                        player.getFirstName(), player.getLastName(), player.getPosition()));
            }

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder output = new StringBuilder();
        playerRepository.findTheBestPlayersInABirthDateRange(LocalDate.of(1995, 1, 1),
                LocalDate.of(2003, 1 ,1))
                .forEach(player -> {
                    output.append(String.format("Player - %s %s%n\tPosition - %s%n\tTeam - %s%n\tStadium - %s%n",
                            player.getFirstName(), player.getLastName(),
                            player.getPosition().name(),
                            player.getTeam().getName(),
                            player.getTeam().getStadiumName()));
                });

        return output.toString();
    }
}
