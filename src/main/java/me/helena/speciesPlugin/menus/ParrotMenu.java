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

public class ParrotMenu implements Listener {

    public void openParrotMenu(Player p) {

        Inventory menu = Bukkit.createInventory(null, 9, "Parrot Variants Menu");

        ItemStack blueItem = ItemUtils.CreateCustomItem(new ItemStack(Material.BLUE_WOOL), "Blue Variant", "", true);
        ItemStack cyanItem = ItemUtils.CreateCustomItem(new ItemStack(Material.CYAN_WOOL), "Cyan Variant", "", true);
        ItemStack grayItem = ItemUtils.CreateCustomItem(new ItemStack(Material.GRAY_WOOL), "Gray Variant", "", true);
        ItemStack greenItem = ItemUtils.CreateCustomItem(new ItemStack(Material.LIME_WOOL), "Green Variant", "", true);
        ItemStack redItem = ItemUtils.CreateCustomItem(new ItemStack(Material.RED_WOOL), "Red Variant", "", true);

        menu.setItem(2, blueItem);
        menu.setItem(3, cyanItem);
        menu.setItem(4, grayItem);
        menu.setItem(5, greenItem);
        menu.setItem(6, redItem);

        p.openInventory(menu);
    }


    @EventHandler
    public void speciesMenuClickListener(InventoryClickEvent event){

        if (event.getView().getTitle().equals("Parrot Variants Menu")){
            event.setCancelled(true);
            ItemStack clickedItem = event.getCurrentItem();
            Player player = (Player) event.getWhoClicked();

            if (clickedItem.getType().name().contains("WOOL")) {

                String colorType = clickedItem.getItemMeta().getDisplayName();
                colorType = colorType.replaceAll(" Variant", "");
                player.sendMessage("You are now a " + colorType + " variant parrot.");
                player.performCommand("disguise Parrot setVariant " + colorType);

            }

            player.closeInventory();


        }
    }

}
