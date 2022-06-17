package tk.jacobcraft.lucifersplugin.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import tk.jacobcraft.lucifersplugin.Main;

public class SpawnListeners implements Listener {

    private final Main plugin;

    public SpawnListeners(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        if (!player.getPlayer().hasPlayedBefore()){
            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){

                player.teleport(location);

                player.sendMessage("§1[§4lucifers§1] §2You have been sent to spawn");
            }else{
                player.sendMessage("§1[§4lucifers§1] §4There is no spawn, use /setspawn to set it.");
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        if (e.isBedSpawn()){
            return;
        }
        //when a player dies, respawn them at the location if its set
        Location location = plugin.getConfig().getLocation("spawn");
        if (location != null){
            e.setRespawnLocation(location);
        }

    }

}
