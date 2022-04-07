package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.jacobcraft.lucifersplugin.Main;

public class CommandSetSpawn implements CommandExecutor {

    private final Main plugin;

    public CommandSetSpawn(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            Location location = player.getLocation();

//            plugin.getConfig().set("spawn.x", location.getX());
//            plugin.getConfig().set("spawn.y", location.getY());
//            plugin.getConfig().set("spawn.z", location.getZ());
//            plugin.getConfig().set("spawn.worldName", location.getWorld().getName());

            plugin.getConfig().set("spawn", location);

            plugin.saveConfig();

            player.sendMessage("§1[§4lucifers§1] §2Spawn location set!");

        }else{
            System.out.println("please connect to the server");
        }

        return true;
    }
}
