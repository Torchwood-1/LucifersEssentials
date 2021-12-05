package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly implements CommandExecutor {
    @Override
    public boolean onCommand (CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equals("fly")){
            if(!(sender instanceof Player)){
                sender.sendMessage("§4you are not a player, get recked!");
                return false;
            }
            if(sender.hasPermission("test.fly")){
                Player player = (Player) sender;
                Boolean allow = !player.getAllowFlight();
                player.setAllowFlight(allow);
                sender.sendMessage(allow? "§ayou are flying!":"§ayou are no longer flying!");
            }else{
                sender.sendMessage("§4you are not authorised, get recked!");
                return false;
            }
            return true;
        }
        return false;
    }
}
