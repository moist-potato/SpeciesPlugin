package me.helena.speciesPlugin.listeners;

import me.helena.speciesPlugin.menus.SpeciesMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinedListener implements Listener {

    SpeciesMenu speciesMenu = new SpeciesMenu();


    @EventHandler
    public void joinedEvent(PlayerJoinEvent event){
        speciesMenu.openMenu(event.getPlayer());
    }

}
