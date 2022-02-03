package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

import java.util.Arrays;

public class CommandInvsee implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;

        if (sender.hasPermission("luciferessentials.invsee.others") && args.length > 0) {
            player = sender.getServer().getPlayer(args[0]);
        } else {
            if (!(sender instanceof Player)) {
                sender.sendMessage("\u00a7cYou need to specify a player");
                return false;
            }
            player = (Player) sender;
        }

        PlayerInventory inv;

        try {
            inv = player.getInventory();
        } catch (NullPointerException err) {
            sender.sendMessage("\u00a7cCouldn't find inventory");
            return true;
        }

        if (sender instanceof Player) {
            if (label.equalsIgnoreCase("armorsee")) {
                // todo: make armorsee actually modify the person's inventory

                if(!sender.hasPermission("luciferessentials.invsee.armor")){
                    sender.sendMessage("\u00a7cYou don't have permission to use armorsee");
                    return true;
                }

                Inventory armor = Bukkit.createInventory(player, InventoryType.HOPPER, "armor");
                armor.setContents(inv.getArmorContents());
                armor.addItem(inv.getItemInOffHand());

                ((Player) sender).openInventory(armor);

                return true;
            }

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