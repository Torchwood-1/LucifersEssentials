package tk.jacobcraft.lucifersplugin.items;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack wand;

    public static void init() {
        createWand();
    }

    private static void createWand() {
    ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4Lucifer's Fury");
        List<String> lore = new ArrayList<>();
        lore.add("§7This powerful artifact is a relic of");
        lore.add("§7Minecraft's ancient history!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DAMAGE_ALL,32767, true);
        meta.addEnchant(Enchantment.KNOCKBACK,25, true);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED,new AttributeModifier("generic.movementSpeed",100, AttributeModifier.Operation.MULTIPLY_SCALAR_1));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        wand = item;
    }

}
