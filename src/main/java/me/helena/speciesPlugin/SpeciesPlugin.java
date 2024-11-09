package me.helena.speciesPlugin;

import me.helena.speciesPlugin.listeners.JoinedListener;
import me.helena.speciesPlugin.menus.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpeciesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        this.getCommand("species").setExecutor(new SpeciesMenuCommand());

        Bukkit.getPluginManager().registerEvents(new SpeciesMenu(), this);
        Bukkit.getPluginManager().registerEvents(new JoinedListener(), this);
        Bukkit.getPluginManager().registerEvents(new FoxMenu(), this);
        Bukkit.getPluginManager().registerEvents(new ParrotMenu(), this);
        Bukkit.getPluginManager().registerEvents(new FrogMenu(), this);
        Bukkit.getPluginManager().registerEvents(new CatMenu(), this);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
