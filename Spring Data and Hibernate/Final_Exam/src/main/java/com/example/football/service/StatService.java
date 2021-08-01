package com.example.football.service;

import java.io.FileNotFoundException;

public interface StatService {
    boolean areImported();

    String readStatsFileContent() throws FileNotFoundException;

    String importStats() ;

}
