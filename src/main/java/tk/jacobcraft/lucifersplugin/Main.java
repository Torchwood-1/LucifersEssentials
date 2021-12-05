package tk.jacobcraft.lucifersplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import tk.jacobcraft.lucifersplugin.commands.*;
import org.bukkit.plugin.java.JavaPlugin;
import tk.jacobcraft.lucifersplugin.events.EventJoin;
import tk.jacobcraft.lucifersplugin.items.ItemManager;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("helloworld").setExecutor(new CommandHelloworld());
        this.getCommand("fly").setExecutor(new CommandFly());
        this.getCommand("stick").setExecutor(new CommandStickItem());
        this.getCommand("feed").setExecutor(new CommandFeed());
        this.getCommand("vanish").setExecutor(new CommandVanish(this));
        this.getCommand("gamemode").setExecutor(new CommandGamemode());
        CommandTime commandTime = new CommandTime();
        this.getCommand("time").setExecutor(commandTime);
        this.getCommand("time").setTabCompleter(commandTime);

        CommandWeather commandWeather = new CommandWeather();
        this.getCommand("weather").setExecutor(commandWeather);
        this.getCommand("weather").setTabCompleter(commandWeather);


        Bukkit.getServer().getPluginManager().registerEvents(new EventJoin(this), this);

        ItemManager.init();


    }

}
