package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByEmail(String email);

    @Query("SELECT p FROM Player p WHERE p.birthDate > :dateBefore AND p.birthDate < :dateAfter" +
            " ORDER BY p.stat.shooting DESC, p.stat.passing DESC, p.stat.endurance DESC, p.lastName" )
    List<Player> findTheBestPlayersInABirthDateRange(LocalDate dateBefore, LocalDate dateAfter);
}
