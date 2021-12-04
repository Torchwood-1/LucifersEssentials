package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandVanish implements CommandExecutor {

    ArrayList<Player> invisible_list = new ArrayList<>();

    tk.jacobcraft.lucifersplugin.Main plugin;
    

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){


        if (sender instanceof Player){
            Player player = (Player) sender;
            if (invisible_list.contains(player)){
                for (Player people: Bukkit.getOnlinePlayers()){
                    people.showPlayer(plugin, player);
                }
                invisible_list.remove(player);
                player.sendMessage("§aYou are now visible to other players on the server");
            }else if (!invisible_list.contains(player)){
                for (Player people: Bukkit.getOnlinePlayers()){
                    people.hidePlayer(plugin, player);
                }
                invisible_list.add(player);
                player.sendMessage("§aYou are now invisible");
            }
        }


        return true;
    }


}
