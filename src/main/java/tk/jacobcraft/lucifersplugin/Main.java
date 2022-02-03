package tk.jacobcraft.lucifersplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import tk.jacobcraft.lucifersplugin.commands.*;
import org.bukkit.plugin.java.JavaPlugin;
import tk.jacobcraft.lucifersplugin.events.EventJoin;
import tk.jacobcraft.lucifersplugin.events.Events;
import tk.jacobcraft.lucifersplugin.items.ItemManager;

public class Main extends JavaPlugin implements Listener {

    FileHandler FileHandler = new FileHandler();
    tk.jacobcraft.lucifersplugin.PlayerHandler PlayerHandler = new PlayerHandler();
    tk.jacobcraft.lucifersplugin.events.Events Events = new Events(PlayerHandler);

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(Events, this);
        FileHandler.Setup();

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

        this.getCommand("tp").setExecutor(new teleport());
        this.getCommand("tpall").setExecutor(new teleportAll());

        this.getCommand("echest").setExecutor(new CommandEchest());
        this.getCommand("invsee").setExecutor(new CommandInvsee());

        CommandWorld commandWorld = new CommandWorld();
        this.getCommand("world").setExecutor(commandWorld);
        this.getCommand("world").setTabCompleter(commandWorld);

        CommandHacks commandHacks = new CommandHacks();
        this.getCommand("hacks").setExecutor(commandHacks);
        this.getCommand("hacks").setTabCompleter(commandHacks);

        CommandRank commandRank = new CommandRank();
        this.getCommand("rank").setExecutor(commandRank);

        CommandHeal commandHeal = new CommandHeal();
        this.getCommand("heal").setExecutor(new CommandHeal());


        Bukkit.getServer().getPluginManager().registerEvents(new EventJoin(this), this);

        ItemManager.init();


    }

}
