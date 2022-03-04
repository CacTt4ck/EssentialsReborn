package cacplugins.essentialsreborn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class EssentialsReborn extends JavaPlugin {

    private static HashMap<Player, Location> backMap;

    @Override
    public void onEnable() {
        // Plugin startup logic
        backMap = new HashMap<Player, Location>();
        TabExecutor executor = new Teleportation();
        this.getCommand("back").setExecutor(executor);
        this.getCommand("back").setTabCompleter(executor);
        this.getCommand("tp").setExecutor(executor);

        Bukkit.getPluginManager().registerEvents(new TeleportListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static HashMap<Player, Location> getBackMap() {
        return backMap;
    }
}
