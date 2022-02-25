package cacplugins.essentialsreborn;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class Utils {

    public static boolean isPlayerOnline(@NotNull String playerName) {
        return Bukkit.getServer().getOnlinePlayers().contains(Bukkit.getServer().getPlayerExact(playerName));
    }

}
