package tk.jacobcraft.lucifersplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;

public class PlayerHandler {

    final static int OWNER = 32767;
    final static int DEV = 32000;
    final static int ULTRAADMIN = 31500;
    final static int ADMIN = 31000;
    final static int MOD = 30000;
    final static int BUILDER = 29000;
    final static int BAE = 20000;
    final static int ELITE = 2500;
    final static int VIP = 2000;
    final static int DONATOR = 1000;
    final static int CITIZEN = 100;
    final static int MEMBER = 0;

    public static void setupPlayer(Player p) {
        File f = new File("plugins/Ranks/PlayerData/" + p.getUniqueId() + ".yml");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.addDefault("Name", p.getName());
        yml.addDefault("Rank", MEMBER);
        yml.options().copyDefaults(true);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean setRank(Player p, int rank) {
        File f = new File("plugins/Ranks/PlayerData/" + p.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        System.out.println(rank);
        yml.set("Rank", rank);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static int getRank(Player p) {
        File f = new File("plugins/Ranks/PlayerData/" + p.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getInt("Rank");
    }

    public static String getRankPrefix(int rank) {
        switch (rank) {
            case OWNER:
                return ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Owner " + ChatColor.WHITE.toString();

            case DEV:
                return ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "Dev " + ChatColor.WHITE.toString();

            case ULTRAADMIN:
                return ChatColor.DARK_RED.toString() + ChatColor.BOLD + "UltraAdmin " + ChatColor.WHITE.toString();

            case ADMIN:
                return ChatColor.RED.toString() + ChatColor.BOLD + "Admin " + ChatColor.WHITE.toString();

            case MOD:
                return ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "Mod " + ChatColor.WHITE.toString();

            case BUILDER:
                return ChatColor.YELLOW.toString() + ChatColor.BOLD + "Builder " + ChatColor.WHITE.toString();

            case BAE:
                return ChatColor.LIGHT_PURPLE.toString() + "Bae " + ChatColor.WHITE.toString();

            case ELITE:
                return ChatColor.BLACK.toString() + "Elite " + ChatColor.WHITE.toString();

            default:
                return "";
        }
    }


    public static void refreshRanks() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            Scoreboard board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
            for (Player pl : Bukkit.getOnlinePlayers()) {
                String prefix = getRankPrefix(getRank(pl));
                Team team = board.registerNewTeam(pl.getName());
                team.setPrefix(prefix);
                team.addEntry(pl.getName());
            }
            p.setScoreboard(board);
        }
    }

    public static int getRankValue(String name) {
        switch (name.toLowerCase()) {
            case "owner":
                return OWNER;
            case "dev":
                return DEV;
            case "ultraadmin":
                return ULTRAADMIN;
            case "admin":
                return ADMIN;
            case "moderator":
                return MOD;
            case "builder":
                return BUILDER;
            case "bae":
                return BAE;
            case "elite":
                return ELITE;
            case "vip":
                return VIP;
            case "donator":
                return DONATOR;
            case "citizen":
                return CITIZEN;
            case "member":
                return MEMBER;
            default:
                return -1;
        }
    }

}

