package tk.jacobcraft.lucifersplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import tk.jacobcraft.lucifersplugin.User;
import tk.jacobcraft.lucifersplugin.utilities.WarnUtil;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e){

        Player player = e.getPlayer();

        e.setQuitMessage("§6Goodbye, §e§o§n" + player.getDisplayName() + " §6Hope you come again soon");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        if(player.hasPlayedBefore()){
            e.setJoinMessage(ChatColor.GREEN + "Welcome back to the server " + ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.GREEN + "!!! We missed you");
        }else {
            e.setJoinMessage(ChatColor.BLUE + "" + ChatColor.BOLD + player.getDisplayName() + ", " + ChatColor.BLUE + " Welcome to our server hope you enjoy your stay.");
        }

//        e.setJoinMessage("§6Hello, §e§o§n" + player.getDisplayName() + "§6Hope you enjoy your stay");
    }

}
