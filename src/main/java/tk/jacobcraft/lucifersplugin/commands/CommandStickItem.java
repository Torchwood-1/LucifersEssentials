package tk.jacobcraft.lucifersplugin.commands;

import tk.jacobcraft.lucifersplugin.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStickItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args){
        if (!(sender instanceof Player )){
            sender.sendMessage("§4You are not a player");
            return false;
        }
        Player player = (Player) sender;
        if ((String.valueOf(player.getUniqueId()).equals("f54da43a-eedc-43cc-bccd-3337334e9a66"))){
            player.getInventory().addItem(ItemManager.wand);
        }else{
            sender.sendMessage("§4You are not Torchwood_one so cannot use this!");
        }
        return true;
    }
}
