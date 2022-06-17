package tk.jacobcraft.lucifersplugin.commands;


import com.sun.istack.internal.Nullable;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.jacobcraft.lucifersplugin.Main;
import tk.jacobcraft.lucifersplugin.User;

public class CommandBack implements CommandExecutor {
    private final Main plugin;

    public CommandBack(Main plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){

            Player player = (Player) sender;

            User user = new User(plugin, player.getUniqueId());

            user.getConfig();
//            @Nullable
//            Location location = user.getConfig().getLocation("backLocation");
//
//            if (location != null){
//
//                player.teleport(location);
//
//                player.sendMessage("§1[§4lucifers§1] §2You have been sent to your previous location");
//            }
        }


        return true;
    }
}