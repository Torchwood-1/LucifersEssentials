package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class SwapInventoryCommand implements CommandExecutor, TabCompleter {

    private final Map<Player, Inventory> inventories = new HashMap<>();
    private final JavaPlugin plugin;

    public SwapInventoryCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by players.");
            return true;
        }

        Player player = (Player) sender;

        // Check if the player has the required permission node.
        if (!player.hasPermission("luciferessentials.swapinventory")) {
            player.sendMessage("You don't have permission to use this command.");
            return true;
        }

        // If no arguments are provided, switch between the player's inventories.
        if (args.length == 0) {
            switchInventory(player);
            return true;
        }

        String subCommand = args[0].toLowerCase();

        // If the argument is "create", create a new inventory for the player.
        if (subCommand.equals("create")) {
            createNewInventory(player);
            return true;
        }

        // If the argument is "switch", switch to the next inventory for the player.
        if (subCommand.equals("switch")) {
            switchInventory(player);
            return true;
        }

        player.sendMessage("Invalid subcommand. Use '/swapinventory create' to create a new inventory, or '/swapinventory switch' to switch to the next inventory.");
        return true;
    }

    // Method to create a new inventory for the player.
    private void createNewInventory(Player player) {
        // You can customize the size and title of the new inventory as per your requirements.
        Inventory newInventory = plugin.getServer().createInventory(null, 27, "New Inventory");
        inventories.put(player, newInventory);
        player.sendMessage("A new inventory has been created. Use '/swapinventory switch' to switch to it.");
    }

    // Method to switch to the next inventory for the player.
    private void switchInventory(Player player) {
        if (!inventories.containsKey(player)) {
            player.sendMessage("You don't have any additional inventories. Create one using '/swapinventory create'.");
            return;
        }

        Inventory currentInventory = player.getInventory();
        Inventory nextInventory = inventories.get(player);

        // Swap the player's inventory with the next inventory.
        player.getInventory().clear();
        player.getInventory().setContents(nextInventory.getContents());
        inventories.put(player, currentInventory);

        player.sendMessage("You have switched to the next inventory.");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> completions = new ArrayList<>();

        // If there are no arguments or only one argument, provide subcommand suggestions.
        if (args.length <= 1) {
            completions.addAll(Arrays.asList("create", "switch"));
        }

        // Return the list of completions.
        return completions;
    }
}
