package tk.jacobcraft.lucifersplugin.events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import tk.jacobcraft.lucifersplugin.Main;

public class ColoredSignsEvent implements Listener {

    public ColoredSignsEvent(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        if(e.getPlayer().hasPermission("lucifers.signcolor")){
            String[] lines = e.getLines();
            for(int i = 0; i < 4; i++) {
                String line = lines[ i ];
                line = ChatColor.translateAlternateColorCodes('&', line);
                e.setLine(i, line);
            }
        }
    }
}