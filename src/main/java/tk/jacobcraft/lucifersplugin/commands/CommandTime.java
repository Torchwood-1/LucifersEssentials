package tk.jacobcraft.lucifersplugin.commands;

import com.google.common.collect.ImmutableList;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public class CommandTime implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        final boolean canSetTime = sender.hasPermission("luciferessentials.time.set");
        int timeToSet;

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command");
            return false;
        }

        Player player = (Player) sender;
        World world = player.getWorld();

        timeToSet = matchTime(args.length > 0 ? args[0] : label);

        if (timeToSet < 0 || (!canSetTime)) {
            sender.sendMessage(String.format("\u00a76The time is: \u00a7a%s", world.getTime()));
            return true;
        }

        world.setTime(timeToSet);
        sender.sendMessage(String.format("\u00a7aSet the time to \u00a7e%s", world.getTime()));

        return true;
    }

    int matchTime(String timeString) {
        switch (timeString) {
            case "day":
                return 1000;
            case "night":
                return 13000;
            case "noon":
                return 6000;
            case "midnight":
                return 18000;
            default:
                try {
                    return Integer.parseInt(timeString);
                } catch (java.lang.NumberFormatException err) {
                    return -1;
                }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(sender.hasPermission("test.time.set")){
            if(args.length == 1){
                return ImmutableList.of("day","night","noon","midnight");
            }
        }

        return ImmutableList.of();
    }
}