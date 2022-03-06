package cacplugins.essentialsreborn;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import java.util.HashMap;

public class TeleportListener implements Listener {

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e) {
        final Player p = e.getPlayer();
        final TeleportCause teleportCause = e.getCause();
        if (!teleportCause.equals(TeleportCause.UNKNOWN)) {
            HashMap<Player, Location> backMap = EssentialsReborn.getBackMap();
            backMap.remove(p);
            backMap.put(p, p.getLocation());
        }
    }

}
