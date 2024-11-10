package me.helena.speciesPlugin;

import me.helena.speciesPlugin.listeners.JoinedListener;
import me.helena.speciesPlugin.menus.*;
import me.helena.speciesPlugin.models.PlayerData;
import me.helena.speciesPlugin.species.Cat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class SpeciesPlugin extends JavaPlugin {

    private static final HashMap<UUID, PlayerData> playerData = new HashMap<>();

    public static SpeciesPlugin getInstance() {
        return getPlugin(SpeciesPlugin.class);
    }

    @Override
    public void onEnable() {

        this.getCommand("species").setExecutor(new SpeciesMenuCommand());

        Bukkit.getPluginManager().registerEvents(new SpeciesMenu(), this);
        Bukkit.getPluginManager().registerEvents(new JoinedListener(), this);
        Bukkit.getPluginManager().registerEvents(new FoxMenu(), this);
        Bukkit.getPluginManager().registerEvents(new ParrotMenu(), this);
        Bukkit.getPluginManager().registerEvents(new FrogMenu(), this);
        Bukkit.getPluginManager().registerEvents(new CatMenu(), this);
        Bukkit.getPluginManager().registerEvents(new Cat(1), this);


        for (Player p : Bukkit.getOnlinePlayers()) {

            playerData.put(p.getUniqueId(), new PlayerData(p.getUniqueId(), 0));

        }

    }


    public static PlayerData getPlayerData(UUID player){return playerData.get(player);}
    public static HashMap<UUID, PlayerData> getPlayerDataHashmap() { return playerData;}


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
