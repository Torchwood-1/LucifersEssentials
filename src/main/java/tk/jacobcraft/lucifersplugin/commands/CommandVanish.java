package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.jacobcraft.lucifersplugin.Main;
import java.util.ArrayList;

public class CommandVanish implements CommandExecutor {

    public static ArrayList<Player> invisible_list = new ArrayList<>();

    Main plugin;

    public CommandVanish (Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        Player player = null;

        if(args.length > 0){
            if(!sender.hasPermission("luciferessentials.vanish.others")){
                sender.sendMessage("§1[§4lucifers§1] &bYou are not authorised");
                return false;
            }

            player = sender.getServer().getPlayer(args[0]);
        }else if (sender instanceof Player){
            player = (Player) sender;
        }else{
            sender.sendMessage("§1[§4lucifers§1] §bYou must specify a player to vanish!");
        }

        if(player == null){
            sender.sendMessage("§1[§4lucifers§1] §bCould not find player");
            return false;
        }

        if (invisible_list.contains(player)){
            for (Player people: Bukkit.getOnlinePlayers()){
                people.showPlayer(plugin, player);
            }
            invisible_list.remove(player);
            player.sendMessage("§1[§4lucifers§1] §bYou are now visible to other players on the server");
        }else if (!invisible_list.contains(player)){
            for (Player people: Bukkit.getOnlinePlayers()){
                people.hidePlayer(plugin, player);
            }
            invisible_list.add(player);
            player.sendMessage("§1[§4lucifers§1] §bYou are now invisible");
        }


        return true;
    }


}
