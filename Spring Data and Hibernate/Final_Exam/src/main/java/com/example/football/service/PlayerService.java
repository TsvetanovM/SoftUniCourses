package com.example.football.service;

import java.io.FileNotFoundException;

public interface PlayerService {
    boolean areImported();

    String readPlayersFileContent() throws FileNotFoundException;

    String importPlayers() ;

    String exportBestPlayers();
}
