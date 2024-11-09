package me.helena.speciesPlugin.menus;

import me.helena.speciesPlugin.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class FrogMenu implements Listener {

    public void openFrogMenu(Player p) {

        Inventory menu = Bukkit.createInventory(null, 9, "Frog Variants Menu");

        ItemStack coldVariantItem = ItemUtils.CreateCustomItem(new ItemStack(Material.GREEN_TERRACOTTA), "Cold Variant", "", true);
        ItemStack temperateVariantItem = ItemUtils.CreateCustomItem(new ItemStack(Material.ORANGE_TERRACOTTA), "Temperate Variant", "", true);
        ItemStack warmVariantItem = ItemUtils.CreateCustomItem(new ItemStack(Material.LIGHT_GRAY_TERRACOTTA), "Warm Variant", "", true);


        menu.setItem(3, coldVariantItem);
        menu.setItem(4, temperateVariantItem);
        menu.setItem(5, warmVariantItem);

        p.openInventory(menu);
    }


    @EventHandler
    public void speciesMenuClickListener(InventoryClickEvent event){

        if (event.getView().getTitle().equals("Frog Variants Menu")){
            event.setCancelled(true);
            ItemStack clickedItem = event.getCurrentItem();
            Player player = (Player) event.getWhoClicked();

            if (clickedItem.getType().name().contains("TERRACOTTA")) {

                String variantType = clickedItem.getItemMeta().getDisplayName();
                variantType = variantType.replaceAll(" Variant", "");
                player.sendMessage("You are now a " + variantType + " variant frog.");
                player.performCommand("disguise frog setVariant " + variantType);

            }

            player.closeInventory();


        }
    }
}
