package me.helena.speciesPlugin.species;

import me.helena.speciesPlugin.SpeciesPlugin;
import me.helena.speciesPlugin.models.Species;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cat extends Species implements Listener {


    public Cat(int id){
        super("Cat", 4, true);

    }

    @Override
    public Set<PotionEffect> effects(){
        return new HashSet<>(List.of(
                new PotionEffect(PotionEffectType.NIGHT_VISION, -1, 1)
        ));
    }



    @EventHandler
    public void fallEvent(EntityDamageEvent event){
        Bukkit.broadcastMessage("listening");
       if (event.getCause() == EntityDamageEvent.DamageCause.FALL
               && event.getEntity() instanceof Player
               && SpeciesPlugin.getPlayerData(event.getEntity().getUniqueId()).getSpecies() == this) {
           event.setCancelled(true);
       }
    }
}
