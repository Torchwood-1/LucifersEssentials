package tk.jacobcraft.lucifersplugin.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import static net.md_5.bungee.api.ChatColor.translateAlternateColorCodes;
import static org.bukkit.Bukkit.getLogger;

public class CommandRules
        implements CommandExecutor {
    JavaPlugin plugin;

    public CommandRules(JavaPlugin javaPlugin) {
        super();
        plugin = javaPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            File dataFolder = plugin.getDataFolder();
            String path = dataFolder.getPath()
                    + "/rules.txt";
            File file = new File(path);
            if (!file.exists()) {
                plugin.saveResource("rules.txt", false);
                sender.sendMessage("The File has been created");
                return true;
            }
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sender.sendMessage(translateAlternateColorCodes('&',line));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            sender.sendMessage("File not found!");
        }
        return true;
    }

}