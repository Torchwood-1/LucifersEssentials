package tk.jacobcraft.lucifersplugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.UUID;

public class User extends Configuration {

    public User(JavaPlugin instance, UUID uuid) {
        super(instance, instance.getDataFolder() + File.separator + "userdata", String.valueOf(uuid), true, false);
    }
}