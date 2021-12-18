package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CommandEchest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;

        if (sender.hasPermission("test.echest.others") && args.length > 0) {
            player = sender.getServer().getPlayer(args[0]);
        } else {
            if (!(sender instanceof Player)) {
                sender.sendMessage("\u00a7cYou need to specify a player");
                return false;
            }
            player = (Player) sender;
        }

        Inventory inv;

        try {
            inv = player.getEnderChest();
        } catch (NullPointerException err) {
            sender.sendMessage("\u00a7cCouldn't find enderchest");
            return true;
        }

        if (sender instanceof Player) {
            ((Player) sender).openInventory(inv);
        } else {
            inv.forEach(item -> {
                if (item == null) {
                    return;
                }
                try {
                    sender.sendMessage(
                            String.format("%s\t%s\tx%s\t%s", item.getType(), item.getItemMeta().getDisplayName(), String.valueOf(item.getAmount()), item.getEnchantments())
                    );
                } catch (NullPointerException err) {
                }
            });
        }

        return true;
    }
}