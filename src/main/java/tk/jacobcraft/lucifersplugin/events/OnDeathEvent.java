package tk.jacobcraft.lucifersplugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import tk.jacobcraft.lucifersplugin.Configuration;
import tk.jacobcraft.lucifersplugin.User;


public class OnDeathEvent implements Listener {
    JavaPlugin plugin;
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        Configuration user = new User(plugin, player.getUniqueId());

        plugin.getLogger().info(String.valueOf(user.getConfig() == null));
        plugin.getLogger().info(String.valueOf(user == null));
        user.getConfig().set("backLocation", player.getLocation());
        user.save();
    }
    public OnDeathEvent (JavaPlugin plugin){
        this.plugin = plugin;
    }
}
