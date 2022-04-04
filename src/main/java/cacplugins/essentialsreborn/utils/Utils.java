package cacplugins.essentialsreborn.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Utils {

    public static boolean isPlayerOnline(@NotNull String playerName) {
        return Bukkit.getServer().getOnlinePlayers().contains(Bukkit.getServer().getPlayerExact(playerName));
    }

    public static List<String> getOtherOnlinePlayerList(Collection<? extends Player> players, Player sender) {
        List<String> list = new ArrayList<String>();
        for (Player player : players)
            list.add(player.getName());
        list.remove(sender.getName());
        return list;
    }

}
