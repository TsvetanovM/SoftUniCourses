package footballBetting.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "bet_money")
    private BigDecimal betMoney;
    @Column(name = "time_of_bet")
    private LocalDateTime timeOfBet;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "bet")
    private Set<BetGame> betGames;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    public LocalDateTime getTimeOfBet() {
        return timeOfBet;
    }

    public void setTimeOfBet(LocalDateTime timeOfBet) {
        this.timeOfBet = timeOfBet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<BetGame> getBetGames() {
        return betGames;
    }

    public void setBetGames(Set<BetGame> betGames) {
        this.betGames = betGames;
    }
}
