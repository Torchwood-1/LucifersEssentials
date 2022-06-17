package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class CommandWorld implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§1[§4lucifers§1] §4You are not a player!");
            return false;
        }

        Server server = sender.getServer();

        Player player = (Player) sender;
        World world = server.getWorld(args[0]);
        if (world == null) {
            sender.sendMessage("§1[§4lucifers§1] §4 " + args[0] + "is not a world");
            return false;
        }


        player.teleport(new Location(world, player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ()));
        sender.sendMessage("§1[§4lucifers§1] §a You have changed World to " + world.getName());
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return sender.getServer().getWorlds().stream().map(World::getName).collect(Collectors.toList());
    }
}
