package tk.jacobcraft.lucifersplugin.commands;

import com.google.common.collect.ImmutableList;
import org.bukkit.command.TabCompleter;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class CommandWeather implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        final boolean canSetWeather = sender.hasPermission("test.weather.set");
        Boolean weatherToSet = null;

        if (!(sender instanceof Player)) {
            sender.sendMessage("\u00a7cOnly players can use this command!");
            return false;
        }

        Player player = (Player) sender;
        World world = player.getWorld();

        weatherToSet = matchWeather(args.length < 1 ? label : args[0]);

        if (weatherToSet == null || (!canSetWeather)) {
            sender.sendMessage(String.format("\u00a76It is currently \u00a7e%s", world.hasStorm() ? "raining" : "sunny"));
            return true;
        }

        world.setStorm(weatherToSet);

        sender.sendMessage(String.format("\u00a76Set the weather to \u00a7e" + (world.hasStorm() ? "rain" : "sun")));
        return true;
    }


    Boolean matchWeather(String weatherString) {
        switch (weatherString) {
            case "clear":
            case "sun":
            case "not_raining":
                return false;
            case "rain":
            case "storm":
            case "snow":
                return true;
            default:
                return null;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender.hasPermission("test.weather.set")) {
            if (args.length == 1) {
                return ImmutableList.of("clear", "sun", "not_raining", "rain", "storm", "snow");
            }
        }

        return ImmutableList.of();
    }
}