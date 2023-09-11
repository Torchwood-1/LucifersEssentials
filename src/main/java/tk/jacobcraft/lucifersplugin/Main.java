package tk.jacobcraft.lucifersplugin;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scoreboard.*;
import tk.jacobcraft.lucifersplugin.commands.*;
import org.bukkit.plugin.java.JavaPlugin;
import tk.jacobcraft.lucifersplugin.events.*;
import tk.jacobcraft.lucifersplugin.items.ItemManager;


public class Main extends JavaPlugin implements Listener {


    FileHandler FileHandler = new FileHandler();
    PlayerHandler PlayerHandler = new PlayerHandler();
    Events events = new Events(PlayerHandler);

    @Override
    public void onEnable() {
        //config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);

        // Plugin startup logic
        getServer().getPluginManager().registerEvents(events, this);
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

        SwapInventoryCommand swapInventoryCommand = new SwapInventoryCommand(this);
        this.getCommand("swapinventory").setExecutor(swapInventoryCommand);
        this.getCommand("swapinventory").setTabCompleter(swapInventoryCommand);

//        CommandRank commandRank = new CommandRank();
//        this.getCommand("rank").setExecutor(commandRank);

        CommandHeal commandHeal = new CommandHeal();
        this.getCommand("heal").setExecutor(new CommandHeal());

        getCommand("color").setExecutor(new CommandColour());

        CommandSkull commandSkull = new CommandSkull();
        this.getCommand("skull").setExecutor(new CommandSkull());

        getCommand("glow").setExecutor(new CommandGlow());

        getCommand("setspawn").setExecutor(new CommandSetSpawn(this));
        getCommand("spawn").setExecutor(new CommandSpawn(this));

        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);

        getCommand("respawn").setExecutor(new CommandRespawn());

        Bukkit.getServer().getPluginManager().registerEvents(new EventJoin(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new EventPlayerChat(), this);

        getServer().getPluginManager().registerEvents(new OnDeathEvent(this), this);
        getCommand("back").setExecutor(new CommandBack(this));

        getCommand("rules").setExecutor(new CommandRules(this));
        getCommand("broadcast").setExecutor(new CommandBroadcast());
        getCommand("warn").setExecutor(new CommandWarn(this));

        getCommand("set-displayname").setExecutor(new CommandSetDisplayName());



        ItemManager.init();

        new ColoredSignsEvent(this);

//        getServer().getPluginManager().registerEvents(new PlayerTickListener(), this);
    }

//    public class PlayerTickListener implements Listener {
//
//        @EventHandler
//        public void onPlayerTick(PlayerMoveEvent event) {
//            Player player = event.getPlayer();
//            Location loc = player.getLocation();
//
//            String subtitleText = formatCoordinates(loc);
//            player.sendTitle("", subtitleText, 0, 10, 0);
//
//        }
//
//        public String formatCoordinates(Location loc) {
//            int x = loc.getBlockX();
//            int y = loc.getBlockY();
//            int z = loc.getBlockZ();
//            return ChatColor.GREEN + "X: " + x + " Y: " + y + " Z: " + z;
//        }
//    }

    public String prefix = "§1[§4lucifers§1] §b";
}




