package viceCity.core;

import viceCity.Main;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Map;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private ArrayDeque<Player> civilPlayers;
    private ArrayDeque<Gun> guns;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayDeque<>();
        this.guns = new ArrayDeque<>();
    }

    @Override
    public String addPlayer(String name) {
        civilPlayers.offer(new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        String output = String.format(GUN_ADDED, name, type);
        ;
        switch (type) {
            case "Pistol":
                guns.offer(new Pistol(name));
                break;
            case "Rifle":
                guns.offer(new Rifle(name));
                break;
            default:
                output = GUN_TYPE_INVALID;
                break;
        }
        return output;
    }

    @Override
    public String addGunToPlayer(String name) {
        if (guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }
        if (name.equals("Vercetti")) {
            Gun gun = guns.poll();
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }
        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.getName().equals(name)) {
                Gun gun = guns.poll();
                civilPlayer.getGunRepository().add(gun);
                return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), civilPlayer.getName());
            }
        }

        return CIVIL_PLAYER_DOES_NOT_EXIST;
    }

    @Override
    public String fight() {
        return null;
    }
}
