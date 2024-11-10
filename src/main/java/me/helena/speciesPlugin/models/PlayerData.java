package me.helena.speciesPlugin.models;

import me.helena.speciesPlugin.SpeciesPlugin;

import java.util.UUID;

public class PlayerData {

    private UUID uuid;
    private int species;



    public PlayerData(UUID uuid, int species) {

        this.species = species;
        this.uuid = uuid;
    }


    public Species getSpecies() {

        return SpeciesType.fromID(this.species);
    }

    public void setSpecies(int species) {
        this.species = species;
        save();
    }


    public void save(){

        SpeciesPlugin.getPlayerDataHashmap().put(this.uuid, this);

    }


}
