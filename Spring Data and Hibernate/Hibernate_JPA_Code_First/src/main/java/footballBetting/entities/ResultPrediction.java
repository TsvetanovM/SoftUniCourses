package footballBetting.entities;

import Base.BaseEntity;
import footballBetting.enums.Prediction;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction extends BaseEntity {

    private Prediction prediction;

    @OneToMany(mappedBy = "resultPrediction")
    private Set<BetGame> betGames;

    public Prediction getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction prediction) {
        this.prediction = prediction;
    }

    public Set<BetGame> getBetGames() {
        return betGames;
    }

    public void setBetGames(Set<BetGame> betGames) {
        this.betGames = betGames;
    }
}
