package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class teleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage(ChatColor.RED + "You need to enter some arguments.");
                player.sendMessage(ChatColor.YELLOW + "To teleport to yourself: /tp <otherplayer>");
                player.sendMessage(ChatColor.YELLOW + "To teleport otherS: /tp <player> <otherplayer>");
                }else if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);

                try{
                    player.teleport(target.getLocation());
                }catch (NullPointerException e) {
                    player.sendMessage(ChatColor.RED + "PLayer does not exist.");
                }
            }else if(args.length == 2){
               //First player
                Player playerTosend = Bukkit.getPlayer(args[0]);
                Player target = Bukkit.getPlayer(args[1]);
                try{
                    playerTosend.teleport(target.getLocation());
                }catch (NullPointerException e){
                    player.sendMessage(ChatColor.RED + "PLayer does not exist.");
                }

            }

        }


        return true;
    }
}
