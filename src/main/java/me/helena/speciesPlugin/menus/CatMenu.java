package me.helena.speciesPlugin.menus;

import me.helena.speciesPlugin.utils.CC;
import me.helena.speciesPlugin.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class CatMenu implements Listener {
    public void openCatMenu(Player player) {
        Inventory menu = Bukkit.createInventory(null, 27, "Cat Variants Menu");
        ItemStack whiteItem = ItemUtils.CreateCustomItem(new ItemStack(Material.WHITE_WOOL), "White", CC.translate("&fwhite"), true);
        ItemStack blackItem = ItemUtils.CreateCustomItem(new ItemStack(Material.BLACK_CONCRETE_POWDER), "Tuxedo", CC.translate("&fblack"), true);
        ItemStack redItem = ItemUtils.CreateCustomItem(new ItemStack(Material.ORANGE_WOOL), "Red", CC.translate("&fred"), true);
        ItemStack siameseItem = ItemUtils.CreateCustomItem(new ItemStack(Material.BROWN_WOOL), "Siamese", CC.translate("&fsiamese"), true);
        ItemStack britishShorthairItem = ItemUtils.CreateCustomItem(new ItemStack(Material.LIGHT_GRAY_WOOL), "British Shorthair", CC.translate("&fbritish_shorthair"), true);
        ItemStack calicoItem = ItemUtils.CreateCustomItem(new ItemStack(Material.ORANGE_CONCRETE_POWDER), "Calico", CC.translate("&fcalico"), true);
        ItemStack persianItem = ItemUtils.CreateCustomItem(new ItemStack(Material.WHITE_TERRACOTTA), "Persian", CC.translate("&fpersian"), true);
        ItemStack ragdollItem = ItemUtils.CreateCustomItem(new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER), "Ragdoll", CC.translate("&fragdoll"), true);
        ItemStack tabbyItem = ItemUtils.CreateCustomItem(new ItemStack(Material.BROWN_CONCRETE_POWDER), "Tabby", CC.translate("&ftabby"), true);
        ItemStack allBlackItem = ItemUtils.CreateCustomItem(new ItemStack(Material.BLACK_WOOL), "Black", CC.translate("&fall_black"), true);
        ItemStack jellieItem = ItemUtils.CreateCustomItem(new ItemStack(Material.GRAY_WOOL), "Jellie", CC.translate("&fjellie"), true);

        menu.setItem(2, whiteItem);
        menu.setItem(3, blackItem);
        menu.setItem(4, redItem);
        menu.setItem(5, siameseItem);
        menu.setItem(6, britishShorthairItem);
        menu.setItem(12, calicoItem);
        menu.setItem(13, persianItem);
        menu.setItem(14, ragdollItem);
        menu.setItem(21, tabbyItem);
        menu.setItem(22, allBlackItem);
        menu.setItem(23, jellieItem);

        player.openInventory(menu);
    }

    @EventHandler
    public void speciesMenuClickListener(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("Cat Variants Menu")) {
            event.setCancelled(true);
            ItemStack clickedItem = event.getCurrentItem();
            Player player = (Player) event.getWhoClicked();

            if (clickedItem.getType() != Material.AIR) {

                List<String> type = clickedItem.getItemMeta().getLore();

                String firstLine = type.getFirst();

                firstLine = ChatColor.stripColor(firstLine);

                player.sendMessage("You are now a " + clickedItem.getItemMeta().getDisplayName() + " cat");
                player.performCommand("disguise Cat setType " + firstLine);

            }

            player.closeInventory();


        }
    }
}
