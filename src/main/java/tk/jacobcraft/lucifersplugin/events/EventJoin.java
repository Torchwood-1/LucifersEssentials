package tk.jacobcraft.lucifersplugin.events;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import org.bukkit.event.player.PlayerQuitEvent;
import tk.jacobcraft.lucifersplugin.User;
import tk.jacobcraft.lucifersplugin.commands.CommandVanish;
import tk.jacobcraft.lucifersplugin.Main;
import tk.jacobcraft.lucifersplugin.utilities.WarnUtil;

import java.util.UUID;

public class EventJoin implements Listener {

    Main plugin;

    public EventJoin(Main plugin){
        this.plugin = plugin;
    }



    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        System.out.println(player.getName() + " Joined the server!");
        for(Player p : CommandVanish.invisible_list){
            player.hidePlayer(plugin, p);
        }
        WarnUtil.loadWarnings(new User(this.plugin, player.getUniqueId()));
        WarnUtil.removeExpiredWarnings(player);
        WarnUtil.updatePlayerListName(player);
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        WarnUtil.saveWarnings(new User(this.plugin, player.getUniqueId()));
    }
}
