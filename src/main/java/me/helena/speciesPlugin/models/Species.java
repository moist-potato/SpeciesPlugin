package me.helena.speciesPlugin.models;

import me.helena.speciesPlugin.SpeciesPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;

import java.util.HashSet;
import java.util.Set;

public abstract class Species implements Listener {

    private static final SpeciesPlugin speciesPlugin = SpeciesPlugin.getInstance();

    String name;
    int id;
    boolean hasNightVision;


    protected Species(String name, int id, boolean hasNightVision) {
        this.name = name;
        this.id = id;
        this.hasNightVision = hasNightVision;

        Bukkit.getPluginManager().registerEvents(this, SpeciesPlugin.getInstance());
    }


    public Set<PotionEffect> effects(){
        return new HashSet<>();
    }

    @EventHandler
    public void spawnEvent(PlayerRespawnEvent event){

        if  (SpeciesPlugin.getPlayerData(event.getPlayer().getUniqueId()).getSpecies() == this ) {

            for (PotionEffect entry : this.effects()) {
                event.getPlayer().addPotionEffect(entry);
            }
        }
    }

}
