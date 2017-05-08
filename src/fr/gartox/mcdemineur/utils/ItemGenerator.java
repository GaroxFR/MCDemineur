package fr.gartox.mcdemineur.utils;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by GartoxFR on 08/05/2017.
 */
public class ItemGenerator {

    private Material material;
    private String name;
    private short durability;
    private int amount;
    private DyeColor color;

    public ItemGenerator(Material material, int amount) {
        this.material = material;
        this.amount = amount;
        this.durability = -1;
    }

    public ItemStack generate(){
        ItemStack it = new ItemStack(getMaterial(), getAmount());
        ItemMeta meta = it.getItemMeta();
        if(durability >= 0)
            it.setDurability(getDurability());
        if(name != null)
            meta.setDisplayName(getName());
        if(color != null)
            it.setDurability(color.getWoolData());
        it.setItemMeta(meta);
        return it;
    }

    public Material getMaterial() {
        return material;
    }

    public ItemGenerator setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemGenerator setName(String name) {
        this.name = name;
        return this;
    }

    public short getDurability() {
        return durability;
    }

    public ItemGenerator setDurability(short durability) {
        this.durability = durability;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public ItemGenerator setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public DyeColor getColor() {
        return color;
    }

    public ItemGenerator setColor(DyeColor color) {
        this.color = color;
        return this;
    }
}
