package tk.jacobcraft.lucifersplugin.events;

import com.sun.org.glassfish.gmbal.ManagedObject;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import tk.jacobcraft.lucifersplugin.PlayerHandler;

import java.util.Locale;

public class Events implements Listener {

    tk.jacobcraft.lucifersplugin.PlayerHandler PlayerHandler;

    public Events(PlayerHandler _PlayerHandler) {
        PlayerHandler = _PlayerHandler;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        System.out.println(e.getPlayer().getName());
        Player p = e.getPlayer();
        PlayerHandler.setupPlayer(p);
        PlayerHandler.refreshRanks();
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
        Player p = e.getPlayer();
        String name = p.getName();
        String prefix = PlayerHandler.getRankPrefix(PlayerHandler.getRank(p));
        String message = e.getMessage();
        Bukkit.broadcastMessage(prefix + name + ": " + message);
    }
}

