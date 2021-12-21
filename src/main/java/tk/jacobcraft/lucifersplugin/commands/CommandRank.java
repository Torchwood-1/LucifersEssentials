package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.jacobcraft.lucifersplugin.PlayerHandler;

public class CommandRank implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 2) {
            String targetName = args[0];
            Player target = Bukkit.getPlayer(targetName);
            if (target != null) {
                String rankName = args[1].toLowerCase();
                int rankValue = PlayerHandler.getRankValue(rankName);
                if (rankValue >= 0) {
                    if (PlayerHandler.setRank(target, rankValue)) {
                        sender.sendMessage("§aSuccesssfully set " + target.getName() + "'s rank to " + rankName);
                        target.sendMessage("§4Your rank has been changed to " + rankName);
                        PlayerHandler.refreshRanks();
                    }
                } else {
                    sender.sendMessage("§4Error: " + rankName + " is not a rank!");
                }
            } else {
                sender.sendMessage("§4Error: " + targetName + " is not online!");
            }
        } else {
            sender.sendMessage("§6Ussage: /rank <player> <rank>");
        }
        return false;
    }
}
