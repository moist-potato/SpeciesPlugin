package me.helena.speciesPlugin;

import me.helena.speciesPlugin.menus.SpeciesMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeciesMenuCommand implements CommandExecutor {
    SpeciesMenu speciesMenu = new SpeciesMenu();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("species") && sender instanceof Player){

            speciesMenu.openMenu((Player) sender);
            return true;
        } else {
            return false;
        }

    }
}

