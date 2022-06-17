package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class CommandSkull implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);

        Player player = (Player) sender;

        OfflinePlayer ownerPlayer = Bukkit.getOfflinePlayer(args[0]);

        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwningPlayer(ownerPlayer);
        meta.setDisplayName(ChatColor.GREEN + (ownerPlayer).getName() + "'s Head!");
        skull.setItemMeta(meta);

        (player).getInventory().addItem(skull);
        (player).sendMessage(ChatColor.GREEN + "Your head has been delivered. It's in your inventory.");
        return false;
    }
}
