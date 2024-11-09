package me.helena.speciesPlugin.menus;

import me.helena.speciesPlugin.SpeciesMenuCommand;
import me.helena.speciesPlugin.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SpeciesMenu implements Listener {

    FoxMenu foxMenu = new FoxMenu();
    ParrotMenu parrotMenu = new ParrotMenu();
    FrogMenu frogMenu = new FrogMenu();
    CatMenu catMenu = new CatMenu();


    public void openMenu(Player p) {

        Inventory menu = Bukkit.createInventory(null, 9, "Species Menu");

        ItemStack foxItem = ItemUtils.CreateCustomItem(new ItemStack(Material.FOX_SPAWN_EGG), "Fox", "", true);
        ItemStack frogItem = ItemUtils.CreateCustomItem(new ItemStack(Material.FROG_SPAWN_EGG), "Frog", "", true);
        ItemStack dolphinItem = ItemUtils.CreateCustomItem(new ItemStack(Material.DOLPHIN_SPAWN_EGG), "Dolphin", "", true);
        ItemStack catItem = ItemUtils.CreateCustomItem(new ItemStack(Material.CAT_SPAWN_EGG), "Cat", "", true);
        ItemStack parrotItem = ItemUtils.CreateCustomItem(new ItemStack(Material.PARROT_SPAWN_EGG), "Parrot", "", true);

        menu.setItem(0, foxItem);
        menu.setItem(1, frogItem);
        menu.setItem(2, dolphinItem);
        menu.setItem(3, catItem);
        menu.setItem(4, parrotItem);

        p.openInventory(menu);
    }


    @EventHandler
    public void speciesMenuClickListener(InventoryClickEvent event){

        if (event.getView().getTitle().equals("Species Menu")){
            event.setCancelled(true);
            ItemStack clickedItem = event.getCurrentItem();
            Player player = (Player) event.getWhoClicked();

            switch(clickedItem.getType()){
                case FOX_SPAWN_EGG: {
                    foxMenu.openFoxMenu(player);
                    break;
                }
                case FROG_SPAWN_EGG: {
                    frogMenu.openFrogMenu(player);
                    break;
                }
                case DOLPHIN_SPAWN_EGG: {
                    player.sendMessage("You are now a dolphin.");
                    player.performCommand("disguise Dolphin");
                    player.closeInventory();
                    break;
                }
                case CAT_SPAWN_EGG: {
                    catMenu.openCatMenu(player);
                    break;
                }
                case PARROT_SPAWN_EGG: {
                    parrotMenu.openParrotMenu(player);
                    break;
                }
            }

        }
    }








}
