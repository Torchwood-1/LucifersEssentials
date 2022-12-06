package tk.jacobcraft.lucifersplugin;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.UUID;

public class User extends Configuration {
    OfflinePlayer offlinePlayer;

    public User(JavaPlugin instance, UUID uuid) {
        super(instance, instance.getDataFolder() + File.separator + "userdata", String.valueOf(uuid), true, false);
        offlinePlayer = Bukkit.getOfflinePlayer(uuid);
    }

    public static User getUser (JavaPlugin javaPlugin, OfflinePlayer player){
        return new User(javaPlugin, player.getUniqueId());
    }

    public OfflinePlayer getOfflinePlayer() {
        return offlinePlayer;
    }
}