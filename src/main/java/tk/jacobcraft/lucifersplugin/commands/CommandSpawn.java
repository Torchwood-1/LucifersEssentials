package tk.jacobcraft.lucifersplugin.commands;


import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.jacobcraft.lucifersplugin.Main;

public class CommandSpawn implements CommandExecutor {
    private final Main plugin;

    public CommandSpawn(Main plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){

            Player player = (Player) sender;

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){

                player.teleport(location);

                player.sendMessage("§1[§4lucifers§1] §2You have been sent to spawn");
            }else{
                player.sendMessage("§1[§4lucifers§1] §4There is no spawn, use /setspawn to set it.");
            }
        }


        return true;
    }
}
