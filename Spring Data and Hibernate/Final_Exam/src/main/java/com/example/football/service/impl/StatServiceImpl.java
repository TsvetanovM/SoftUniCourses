package com.example.football.service.impl;

import com.example.football.models.dto.StatImport;
import com.example.football.models.dto.StatsImport;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
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

@Service
public class StatServiceImpl implements StatService {
    private static final String STATS_XML_INPUT_PATH = "./src/main/resources/files/xml/stats.xml";

    private final StatRepository statRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validator;

    public StatServiceImpl(StatRepository statRepository, ModelMapper mapper, ValidationUtil validator) {
        this.statRepository = statRepository;
        this.mapper = mapper;
        this.validator = validator;
    }


    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws FileNotFoundException {
        try {
            return Files.readString(Path.of(STATS_XML_INPUT_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new FileNotFoundException();
    }

    @Override
    public String importStats() {
        StringBuilder output = new StringBuilder();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(StatsImport.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StatsImport statsImport = (StatsImport) unmarshaller.unmarshal(new FileReader(STATS_XML_INPUT_PATH));

            for (StatImport statImport : statsImport.getStats()) {
                if (!validator.isValid(statImport)
                        || statRepository.existsByEnduranceAndShootingAndPassing(
                        statImport.getEndurance(), statImport.getShooting(), statImport.getPassing())) {
                    output.append("Invalid Stat").append(System.lineSeparator());
                    continue;
                }

                statRepository.save(mapper.map(statImport, Stat.class));
                output.append(String.format("Successfully imported Stat %.2f - %.2f - %.2f%n",
                        statImport.getPassing(), statImport.getShooting(), statImport.getEndurance()));
            }
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

        return output.toString();
    }
}
