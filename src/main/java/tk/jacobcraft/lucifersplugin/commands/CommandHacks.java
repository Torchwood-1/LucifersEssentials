package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class CommandHacks implements CommandExecutor, TabCompleter{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§1[§4lucifers§1] §4You are not a player!");
            return false;
        }
        Player player = ((Player) sender);
        player.kickPlayer("§1[§4lucifers§1] §4Cheating is not allowed on this server!");
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Arrays.asList("aim bot","kill aura","log4j exploit","ping spoofing","creative","auto clicker","Jesus");

    }
}
