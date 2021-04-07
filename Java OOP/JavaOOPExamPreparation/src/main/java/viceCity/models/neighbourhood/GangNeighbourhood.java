package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        ArrayDeque<Gun> mainGuns = new ArrayDeque<>(mainPlayer.getGunRepository().getModels());
        ArrayDeque<Player> players = new ArrayDeque<>(civilPlayers);
        Gun currentGun = mainGuns.poll();
        Player civilPlayer = players.poll();
        while (currentGun != null && civilPlayer != null) {
            while (currentGun.canFire() && civilPlayer.isAlive()) {
                int damage = currentGun.fire();
                civilPlayer.takeLifePoints(damage);
            }
            if (currentGun.canFire()) {
                civilPlayer = players.poll();
            } else {
                currentGun = mainGuns.poll();
            }
        }
    }
}