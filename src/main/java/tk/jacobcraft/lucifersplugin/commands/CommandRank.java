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
                        target.sendMessage("§1[§4lucifers§1] §bYour rank has been changed to " + rankName);
                        PlayerHandler.refreshRanks();
                    }
                } else {
                    sender.sendMessage("§1[§4lucifers§1] §bError: §6§o" + rankName + " §bis not a rank!");
                }
            } else {
                sender.sendMessage("§1[§4lucifers§1] §bError: §6" + targetName + " §bis not online!");
            }
        } else {
            sender.sendMessage("§1[§4lucifers§1] §bUssage: /rank <player> <rank>");
        }
        return false;
    }
}
