package viceCity.models.neighbourhood;

import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
    }

    private Player getCurrentCivilPlayer(Collection<Player> civilPlayers) {
        if (civilPlayers.iterator().hasNext()) {
            return civilPlayers.iterator().next();
        }
        return null;
    }
}