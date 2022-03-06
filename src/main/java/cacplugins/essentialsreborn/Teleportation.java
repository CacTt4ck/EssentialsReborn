package cacplugins.essentialsreborn;

import cacplugins.essentialsreborn.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import java.util.HashMap;
import java.util.List;

public class Teleportation implements TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        final Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("tp")) {
            if (args.length != 1) return false;

            if (Utils.isPlayerOnline(args[0])) {
                Player target = Bukkit.getServer().getPlayerExact(args[0]);
                p.teleportAsync(target.getLocation(), TeleportCause.COMMAND);
            }
        } else if (cmd.getName().equalsIgnoreCase("back")) {
            if (args.length != 0) return false;

            HashMap<Player, Location> backMap = EssentialsReborn.getBackMap();
            if (!backMap.containsKey(p)) return false;
            p.teleportAsync(backMap.get(p), TeleportCause.UNKNOWN);
        }
        return false;
    }


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String alias, @NotNull String[] args) {
        if (cmd.getName().equalsIgnoreCase("tp")) {
            if (args.length == 0) {
                return Utils.getOnlinePlayerList(Bukkit.getServer().getOnlinePlayers(), (Player) sender);
            }
        }
        return null;
    }
}
