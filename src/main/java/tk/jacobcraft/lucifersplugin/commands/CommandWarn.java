package tk.jacobcraft.lucifersplugin.commands;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import tk.jacobcraft.lucifersplugin.utilities.WarnUtil;

import static org.bukkit.Bukkit.getServer;

public class CommandWarn implements CommandExecutor {

    JavaPlugin plugin;

    public CommandWarn(JavaPlugin plugin) {
        super();
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("Usage: /warn <player> <message>");
            return false;
        }

        String playerName = args[0];
        Player player = getServer().getPlayer(playerName);
        if (player == null) {
            sender.sendMessage("Player not found: " + playerName);
            return false;
        }

        String message = String.join(" ", args[1]);
        player.sendMessage("[Warning] " + message);

//        UUID playerId = player.getUniqueId();
        long expiration = System.currentTimeMillis() + 300000; // Warning expires in 5 minutes
        WarnUtil.addWarning(player, expiration, plugin);

        Scoreboard scoreboard = player.getScoreboard();
        Objective objective = scoreboard.getObjective("warnings");
        if (objective == null) {
            objective = scoreboard.registerNewObjective("warnings", "dummy");
            objective.setDisplayName("Warnings");
        }

        int numWarnings = WarnUtil.getWarnings(player).size();
        objective.getScore(player.getName()).setScore(numWarnings);

        WarnUtil.updatePlayerListName(player);

        return true;
    }
}

