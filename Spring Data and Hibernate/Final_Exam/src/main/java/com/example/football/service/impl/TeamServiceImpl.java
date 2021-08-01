package com.example.football.service.impl;

import com.example.football.models.dto.TeamImport;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TeamServiceImpl implements TeamService {
    private static final String TEAMS_JSON_INPUT_PATH = "./src/main/resources/files/json/teams.json";

    private final TownRepository townRepository;
    private final TeamRepository teamRepository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validator;

    public TeamServiceImpl(TownRepository townRepository, TeamRepository teamRepository, Gson gson, ModelMapper mapper, ValidationUtil validator) {
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.gson = gson;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() {
        try {
            return Files.readString(Path.of(TEAMS_JSON_INPUT_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No file found at the provided path";
    }

    @Override
    public String importTeams() {
        StringBuilder output = new StringBuilder();

        TeamImport[] teamImports = gson.fromJson(readTeamsFileContent(), TeamImport[].class);
        for (TeamImport teamImport : teamImports) {
            if (!validator.isValid(teamImport) || teamRepository.existsByName(teamImport.getName())) {
                output.append("Invalid Team").append(System.lineSeparator());
                continue;
            }
            Team team = mapper.map(teamImport, Team.class);
            team.setTown(townRepository.findByName(teamImport.getTownName()));
            teamRepository.save(team);
            output.append(String.format("Successfully imported Team %s - %d%n", team.getName(), team.getFanBase()));
        }
        return output.toString();
    }
}
