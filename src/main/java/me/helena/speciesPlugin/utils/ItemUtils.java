package me.helena.speciesPlugin.utils;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
public class ItemUtils {


    public static ItemStack CreateCustomItem(ItemStack i, String name, String lore, Boolean shiny) {

        ItemMeta itemMeta = i.getItemMeta();
        String itemName = CC.translate(name);
        List<String> lore1 = new ArrayList<>();

        if (!lore.isEmpty()) {
            String[] itemLore =  lore.split("\n");
            for (String m : itemLore) {lore1.add(CC.translate(m));}

        }

        itemMeta.setLore(lore1);
        itemMeta.setDisplayName(itemName);
        i.setItemMeta(itemMeta);

        if (shiny) i.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);

        return i;
    }
}
