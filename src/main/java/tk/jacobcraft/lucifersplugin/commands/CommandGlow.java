package tk.jacobcraft.lucifersplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

    public class CommandGlow implements CommandExecutor {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage("This command can only be used by players.");
                    return true;
                }

                Player player = (Player) sender;
                Scoreboard scoreboard = player.getScoreboard();

                if (args.length == 0) {
                    sender.sendMessage("Please specify a team or 'off' to turn off the effect.");
                    return true;
                }

                String teamName = args[0];

                if (teamName.equalsIgnoreCase("off")) {
                    // Remove the player from their team
                    Team team = scoreboard.getEntryTeam(player.getName());
                    if (team != null) {
                        team.removeEntry(player.getName());
                    }
                    // Turn off the glowing effect
                    player.removePotionEffect(PotionEffectType.GLOWING);
                    sender.sendMessage("Glow effect turned off.");
                    return true;
                }

                // Check if the team already exists
                Team team = scoreboard.getTeam(teamName);
                if (team == null) {
                    // Create a new team with the specified name
                    team = scoreboard.registerNewTeam(teamName);
                    team.setAllowFriendlyFire(false);
                    team.setCanSeeFriendlyInvisibles(true);
                    team.setColor(ChatColor.valueOf(teamName.toUpperCase()));
                }

                // Add the player to the team
                team.addEntry(player.getName());

                // Get the team color
                ChatColor color = team.getColor();

                // Use the team color to set the glowing effect
                int duration = 20000000 * 60; // 20 seconds
                int amplifier = 1; // Strong glow effect
                PotionEffect effect = new PotionEffect(PotionEffectType.GLOWING, duration, amplifier, true, color.isColor());
                player.addPotionEffect(effect);

                sender.sendMessage("You are now glowing with your team's color!");

                return true;
            }
        }