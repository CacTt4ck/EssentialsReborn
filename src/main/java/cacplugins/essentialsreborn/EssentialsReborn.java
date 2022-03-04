package cacplugins.essentialsreborn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.logging.Logger;

public final class EssentialsReborn extends JavaPlugin {

    private static HashMap<Player, Location> backMap;
    private Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic

        logger.info(" ______  _____ _____ ______ _   _ _______ _____          _       _____   _____  ______ ____   ____  _____  _   _ ");
        logger.info("|  ____|/ ____/ ____|  ____| \\ | |__   __|_   _|   /\\   | |     / ____| |  __ \\|  ____|  _ \\ / __ \\|  __ \\| \\ | |");
        logger.info("| |__  | (___| (___ | |__  |  \\| |  | |    | |    /  \\  | |    | (___   | |__) | |__  | |_) | |  | | |__) |  \\| |");
        logger.info("|  __|  \\___ \\\\___ \\|  __| | . ` |  | |    | |   / /\\ \\ | |     \\___ \\  |  _  /|  __| |  _ <| |  | |  _  /| . ` |");
        logger.info("| |____ ____) |___) | |____| |\\  |  | |   _| |_ / ____ \\| |____ ____) | | | \\ \\| |____| |_) | |__| | | \\ \\| |\\  |");
        logger.info("|______|_____/_____/|______|_| \\_|  |_|  |_____/_/    \\_\\______|_____/  |_|  \\_\\______|____/ \\____/|_|  \\_\\_| \\_|");
        logger.info(" ");

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
