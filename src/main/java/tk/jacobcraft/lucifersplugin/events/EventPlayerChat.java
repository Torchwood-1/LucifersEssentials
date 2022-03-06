package tk.jacobcraft.lucifersplugin.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import tk.jacobcraft.lucifersplugin.PlayerHandler;

import static tk.jacobcraft.lucifersplugin.utilities.ColorUtils.translateColorCodes;

public class EventPlayerChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
        Player p = e.getPlayer();
        String name = p.getName();
        String prefix = PlayerHandler.getRankPrefix(PlayerHandler.getRank(p));
        String message = e.getMessage();
        if (p.hasPermission("luciferessentials.coloredchat")){
            message = translateColorCodes(message);
        }else {
            if (!message.equals(translateColorCodes(message))) p.sendMessage("§1[§4lucifers§1] §bYou do not have permission!");

        }

        Bukkit.broadcastMessage(prefix + name + ": " + message);
    }

}
