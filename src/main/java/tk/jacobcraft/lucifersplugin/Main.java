package tk.jacobcraft.lucifersplugin;

import tk.jacobcraft.lucifersplugin.commands.*;
import org.bukkit.plugin.java.JavaPlugin;
import tk.jacobcraft.lucifersplugin.items.ItemManager;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("helloworld").setExecutor(new CommandHelloworld());
        this.getCommand("fly").setExecutor(new CommandFly());
        this.getCommand("stick").setExecutor(new CommandStickItem());
        this.getCommand("feed").setExecutor(new CommandFeed());
        this.getCommand("vanish").setExecutor(new CommandVanish());


        ItemManager.init();

    }
}
