package me.helena.speciesPlugin.models;

import me.helena.speciesPlugin.species.Cat;

public enum SpeciesType {

    CAT(1, new Cat(1));


    private final int id;
    private final Species species;


    SpeciesType(int id, Species species) {
        this.id = id;
        this.species = species;
    }

    public static Species fromID(int id) {
        for (SpeciesType e : values())
            if (e.id == id) return e.species;

        return null;
    }
}
