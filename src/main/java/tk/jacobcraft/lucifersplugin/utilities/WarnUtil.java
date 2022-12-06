package tk.jacobcraft.lucifersplugin.utilities;


import org.apache.commons.lang.StringUtils;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import tk.jacobcraft.lucifersplugin.User;

import java.util.*;

public class WarnUtil {
    private static final HashMap<UUID, Set<Long>> warnings = new HashMap<>();

    public static void saveWarnings(User user) {
        if (user.getConfig() == null)
            user.reloadConfig();

        user.getConfig().set("warnings", getWarnings(user.getOfflinePlayer()));
    }

    public static void loadWarnings(User user) {
        warnings.put(user.getOfflinePlayer().getUniqueId(), (Set<Long>) user.getConfig().get("warnings", Collections.EMPTY_LIST));
    }

    public static void addWarning(OfflinePlayer offlinePlayer, Long expiration, JavaPlugin plugin) {
        WarnUtil.removeExpiredWarnings(offlinePlayer);
        UUID uniqueId = offlinePlayer.getUniqueId();
        if (!warnings.containsKey(uniqueId)) {
            warnings.put(uniqueId, new HashSet<>());
        }
        warnings.get(uniqueId).add(expiration);
        saveWarnings(User.getUser(plugin, offlinePlayer));
    }

    public static Set<Long> getWarnings(OfflinePlayer offlinePlayer) {
        UUID uniqueId = offlinePlayer.getUniqueId();
        if (!warnings.containsKey(uniqueId)) {
            warnings.put(uniqueId, new HashSet<>());
        }
        return warnings.get(uniqueId);
    }

    public static void updatePlayerListName(Player player) {
        player.setPlayerListName(String.format("%s %s",
                StringUtils.repeat("*", getWarnings(player).size()),
                player.getDisplayName()));
    }

    public static void removeExpiredWarnings(OfflinePlayer player) {
        Set<Long> playerWarnings = getWarnings(player);
        playerWarnings.forEach(expiration -> {
            if (System.currentTimeMillis() >= expiration) playerWarnings.remove(expiration);
        });
    }
}
