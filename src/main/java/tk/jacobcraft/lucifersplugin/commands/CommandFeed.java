package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFeed implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player target; 
        if (args.length > 0) {
            target = sender.getServer().getPlayer(args[0]);
        }else{
            if (!(sender instanceof Player )){
                sender.sendMessage("§aProvide a Player");
                return false;
            }
            target = (Player) sender;
        }

        if(target == null) {
            sender.sendMessage("§4Player not found");
            return false;
        }
        target.setFoodLevel(20);
        sender.sendMessage("§aYour appetite has been satisfied");
        return false;
    }
}
