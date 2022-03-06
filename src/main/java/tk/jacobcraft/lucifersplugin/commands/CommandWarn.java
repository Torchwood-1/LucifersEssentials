//package tk.jacobcraft.lucifersplugin.commands;
//
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.OfflinePlayer;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//import org.bukkit.plugin.java.JavaPlugin;
//
//import java.util.HashMap;
//
//public class CommandWarn extends JavaPlugin {
//
//    private HashMap <Player, Integer> banned = new HashMap<Player, Integer>();
//
//    @Override
//    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
//        if (cmd.getName().equalsIgnoreCase("warn")){
//
//            if (args.length < 2){
//                sender.sendMessage(ChatColor.RED + "/warn <player reason>");
//                return true;
//            }
//
//            Player target = Bukkit.getServer().getPlayer(args[0]);
//
//            if(target == null){
//                sender.sendMessage(ChatColor.RED + "Could not find player " + args[0]);
//                return true;
//            }
//
//            String msg = "";
//            for (int i = 1; i < args.length; i++) {
//                msg += args[i];
//            }
//
//            Object level = this.getConfig().get(target.getName());
//
//            if (level == null) {
//                target.sendMessage(ChatColor.RED + msg);
//                return true;
//            }
//
//            int l = Integer.parseInt(level.toString());
//
//            if (l == 1) {
//                target.kickPlayer(ChatColor.RED + msg);
//                return true;
//            }
//            if (l == 2){
//                banned.put(target, 10);
//                ((OfflinePlayer)target).setBanned(true);
//                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask()
//                return true;
//            }
//        }
//    }
//}
