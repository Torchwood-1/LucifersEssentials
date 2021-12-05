package tk.jacobcraft.lucifersplugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import tk.jacobcraft.lucifersplugin.commands.CommandVanish;
import tk.jacobcraft.lucifersplugin.Main;

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
    }
}
