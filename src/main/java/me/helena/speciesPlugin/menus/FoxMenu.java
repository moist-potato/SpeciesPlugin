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

public class FoxMenu implements Listener {


    public void openFoxMenu(Player player) {
        Inventory menu = Bukkit.createInventory(null, 9, "Fox Variants Menu");
        ItemStack snowFoxItem = ItemUtils.CreateCustomItem(new ItemStack(Material.SNOW_BLOCK), "Snow Fox", "", true);
        ItemStack redFoxItem = ItemUtils.CreateCustomItem(new ItemStack(Material.ORANGE_WOOL), "Red Fox", "", true);

        menu.setItem(3, snowFoxItem);
        menu.setItem(5, redFoxItem);

        player.openInventory(menu);
    }

    @EventHandler
    public void speciesMenuClickListener(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("Fox Variants Menu")) {
            event.setCancelled(true);
            ItemStack clickedItem = event.getCurrentItem();
            Player player = (Player) event.getWhoClicked();

            if (clickedItem.getType() == Material.SNOW_BLOCK){
                player.sendMessage("You are now a snow fox.");
                player.performCommand("disguise Fox setType SNOW");

            } else if (clickedItem.getType() == Material.ORANGE_WOOL) {
                player.sendMessage("You are now a red fox.");
                player.performCommand("disguise Fox setType RED");
            }

            player.closeInventory();


        }
    }
}