package footballBetting.entities;

import Base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {

   @ManyToOne
   @JoinColumn(name = "home_team_id", referencedColumnName = "id")
   private Team homeTeam;
   @ManyToOne
   @JoinColumn(name = "away_team_id", referencedColumnName = "id")
   private Team awayTeam;
   @Column(name = "home_goals")
   private int homeGoals;
   @Column(name = "away_goals")
   private int awayGoals;
   private LocalDateTime dateTime;
   @OneToMany(mappedBy = "game")
   private Set<BetGame> betGames;
   @Column(name = "home_team_win_bet_rate")
   private double homeTeamWinBetRate;
   @Column(name = "away_team_win_bet_rate")
   private double awayTeamWinBetRate;
   @Column(name = "draw_bet_rate")
   private double drawBetRate;
   @ManyToOne
   private Round round;
   @ManyToOne
   private Competition competition;

   @OneToMany(mappedBy = "game")
   private Set<PlayerStatistic> playerStatistics;

   public Team getHomeTeam() {
      return homeTeam;
   }

   public void setHomeTeam(Team homeTeam) {
      this.homeTeam = homeTeam;
   }

   public Team getAwayTeam() {
      return awayTeam;
   }

   public void setAwayTeam(Team awayTeam) {
      this.awayTeam = awayTeam;
   }

   public int getHomeGoals() {
      return homeGoals;
   }

   public void setHomeGoals(int homeGoals) {
      this.homeGoals = homeGoals;
   }

   public int getAwayGoals() {
      return awayGoals;
   }

   public void setAwayGoals(int awayGoals) {
      this.awayGoals = awayGoals;
   }

   public LocalDateTime getDateTime() {
      return dateTime;
   }

   public void setDateTime(LocalDateTime dateTime) {
      this.dateTime = dateTime;
   }

   public double getHomeTeamWinBetRate() {
      return homeTeamWinBetRate;
   }

   public void setHomeTeamWinBetRate(double homeTeamWinBetRate) {
      this.homeTeamWinBetRate = homeTeamWinBetRate;
   }

   public double getAwayTeamWinBetRate() {
      return awayTeamWinBetRate;
   }

   public void setAwayTeamWinBetRate(double awayTeamWinBetRate) {
      this.awayTeamWinBetRate = awayTeamWinBetRate;
   }

   public double getDrawBetRate() {
      return drawBetRate;
   }

   public void setDrawBetRate(double drawBetRate) {
      this.drawBetRate = drawBetRate;
   }

   public Round getRound() {
      return round;
   }

   public void setRound(Round round) {
      this.round = round;
   }

   public Competition getCompetition() {
      return competition;
   }

   public void setCompetition(Competition competition) {
      this.competition = competition;
   }

   public Set<PlayerStatistic> getPlayerStatistics() {
      return playerStatistics;
   }

   public void setPlayerStatistics(Set<PlayerStatistic> playerStatistics) {
      this.playerStatistics = playerStatistics;
   }

   public Set<BetGame> getBetGames() {
      return betGames;
   }

   public void setBetGames(Set<BetGame> betGames) {
      this.betGames = betGames;
   }
}
