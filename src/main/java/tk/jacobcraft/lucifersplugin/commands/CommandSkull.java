package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandSkull implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);

        Player player = (Player) sender;

        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(args[0]));
        meta.setDisplayName(ChatColor.GREEN + (player).getName() + "'s Head!");
        skull.setItemMeta(meta);

        (player).getInventory().addItem(skull);
        (player).sendMessage(ChatColor.GREEN + "Your head has been delivered. It's in your inventory.");
        return false;
    }
}
