package footballBetting.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bet_game")
public class BetGame implements Serializable {

    @Id
    @ManyToOne
    private Game game;
    @Id
    @ManyToOne
    private Bet bet;
    @ManyToOne
    @JoinColumn(name = "result_prediction_id", referencedColumnName = "id")
    private ResultPrediction resultPrediction;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}
