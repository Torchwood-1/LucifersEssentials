package tk.jacobcraft.lucifersplugin.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandSetDisplayName implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;
        ItemStack item = player.getItemInHand();

        if (item == null || item.getType() == Material.AIR) {
            player.sendMessage("You must be holding an item to use this command.");
            return true;
        }

        ItemMeta meta = item.getItemMeta();

        if (args.length == 0) {
            player.sendMessage("Usage: /set-display <name> [color]");
            return true;
        }

        String name = ChatColor.translateAlternateColorCodes('&', args[0]);

        if (args.length > 1) {
            ChatColor color = ChatColor.valueOf(args[1].toUpperCase());

            if (color != null) {
                name = color + name;
            }
        }

        meta.setDisplayName(name);
        item.setItemMeta(meta);

        player.sendMessage("Item renamed to " + name);

        return true;
    }
}
