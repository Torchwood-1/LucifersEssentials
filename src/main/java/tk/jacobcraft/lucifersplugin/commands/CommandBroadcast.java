package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static net.md_5.bungee.api.ChatColor.translateAlternateColorCodes;
import static org.bukkit.Bukkit.getServer;

public class CommandBroadcast implements CommandExecutor {
    public CommandBroadcast() {
        super();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Usage: /broadcast <message>");
            return false;
        }
        String message = String.join(" ", args);
        getServer().broadcastMessage(translateAlternateColorCodes('&',message));
        return true;
    }
}
