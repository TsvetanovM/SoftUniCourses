package com.example.football.service.impl;

import com.example.football.models.dto.TownImport;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {
    private static final String TOWNS_JSON_INPUT_PATH = "./src/main/resources/files/json/towns.json";

    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validator;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper mapper, ValidationUtil validator) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() {
        try {
            return Files.readString(Path.of(TOWNS_JSON_INPUT_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No JSON files found in the input path!";
    }

    @Override
    public String importTowns() {
        StringBuilder output = new StringBuilder();

        TownImport[] townImports = gson.fromJson(readTownsFileContent(), TownImport[].class);
        for (TownImport townImport : townImports) {
            if (!validator.isValid(townImport)) {
                output.append("Invalid Town").append(System.lineSeparator());
                continue;
            }
            townRepository.save(mapper.map(townImport, Town.class));
            output.append(String.format("Successfully imported Town %s - %d%n",
                    townImport.getName(), townImport.getPopulation()));
        }
        return output.toString();
    }
}
