package cacplugins.essentialsreborn;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Teleportation implements CommandExecutor, TabExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("tp")) {
            if (args.length == 1) {
                if (Utils.isPlayerOnline(args[0])) {
                    Player target = Bukkit.getServer().getPlayerExact(args[0]);
                    p.teleportAsync(target.getLocation(), PlayerTeleportEvent.TeleportCause.COMMAND);
                }
            } else
                return false;
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return null;
    }
}
