package fr.gartox.mcdemineur.utils;

import org.bukkit.Material;

/**
 * Created by Ewan on 07/05/2017.
 */
public enum SquareType {
    ;

    private int value;
    private Material material;

    SquareType(int value, Material material) {
        this.setValue(value);
        this.setMaterial(material);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
