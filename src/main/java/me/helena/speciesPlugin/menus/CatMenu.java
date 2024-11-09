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

public class CatMenu implements Listener {
    public void openCatMenu(Player player) {
        Inventory menu = Bukkit.createInventory(null, 27, "Cat Variants Menu");
        ItemStack whiteItem = ItemUtils.CreateCustomItem(new ItemStack(Material.WHITE_WOOL), "White", "", true);
        ItemStack blackItem = ItemUtils.CreateCustomItem(new ItemStack(Material.BLACK_CONCRETE_POWDER), "Tuxedo", "", true);
        ItemStack redItem = ItemUtils.CreateCustomItem(new ItemStack(Material.ORANGE_WOOL), "Red", "", true);
        ItemStack siameseItem = ItemUtils.CreateCustomItem(new ItemStack(Material.BROWN_WOOL), "Siamese", "", true);
        ItemStack britishShorthairItem = ItemUtils.CreateCustomItem(new ItemStack(Material.LIGHT_GRAY_WOOL), "British Shorthair", "", true);
        ItemStack calicoItem = ItemUtils.CreateCustomItem(new ItemStack(Material.ORANGE_CONCRETE_POWDER), "Calico", "", true);
        ItemStack persianItem = ItemUtils.CreateCustomItem(new ItemStack(Material.WHITE_TERRACOTTA), "Persian", "", true);
        ItemStack ragdollItem = ItemUtils.CreateCustomItem(new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER), "Ragdoll", "", true);
        ItemStack tabbyItem = ItemUtils.CreateCustomItem(new ItemStack(Material.BROWN_CONCRETE_POWDER), "Tabby", "", true);
        ItemStack allBlackItem = ItemUtils.CreateCustomItem(new ItemStack(Material.BLACK_WOOL), "Black", "", true);
        ItemStack jellieItem = ItemUtils.CreateCustomItem(new ItemStack(Material.GRAY_WOOL), "Jellie", "", true);

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
            switch(clickedItem.getType()){
                case WHITE_WOOL: {
                    player.sendMessage("You are now a white cat.");
                    player.performCommand("disguise Cat SetType WHITE");
                    break;
                }

                case BLACK_CONCRETE_POWDER: {
                    player.sendMessage("You are now a tuxedo cat.");
                    player.performCommand("disguise Cat SetType BLACK");
                    break;
                }

                case ORANGE_WOOL: {
                    player.sendMessage("You are now a red cat.");
                    player.performCommand("disguise Cat SetType RED");
                    break;
                }

                case BROWN_WOOL: {
                    player.sendMessage("You are now a siamese cat.");
                    player.performCommand("disguise Cat SetType SIAMESE");
                    break;
                }

                case LIGHT_GRAY_WOOL: {
                    player.sendMessage("You are now a british shorthair cat.");
                    player.performCommand("disguise Cat SetType BRITISH_SHORTHAIR");
                    break;
                }

                case ORANGE_CONCRETE_POWDER: {
                    player.sendMessage("You are now a calico cat.");
                    player.performCommand("disguise Cat SetType CALICO");
                    break;
                }

                case WHITE_TERRACOTTA: {
                    player.sendMessage("You are now a persian cat.");
                    player.performCommand("disguise Cat SetType PERSIAN");
                    break;
                }

                case LIGHT_GRAY_CONCRETE_POWDER: {
                    player.sendMessage("You are now a ragdoll cat.");
                    player.performCommand("disguise Cat SetType RAGDOLL");
                    break;
                }

                case BROWN_CONCRETE_POWDER: {
                    player.sendMessage("You are now a tabby cat.");
                    player.performCommand("disguise Cat SetType TABBY");
                    break;
                }

                case BLACK_WOOL: {
                    player.sendMessage("You are now a black cat.");
                    player.performCommand("disguise Cat SetType ALL_BLACK");
                    break;
                }

                case GRAY_WOOL: {
                    player.sendMessage("You are now a jellie cat.");
                    player.performCommand("disguise Cat SetType JELLIE");
                    break;
                }
            }

            player.closeInventory();


        }
    }
}
