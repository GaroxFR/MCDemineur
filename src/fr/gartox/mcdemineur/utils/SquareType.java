package fr.gartox.mcdemineur.utils;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by GartoxFR on 07/05/2017.
 */
public enum SquareType {
    UNGENGERATED(-2, new ItemGenerator(Material.STAINED_GLASS_PANE, 1).setColor(DyeColor.BLUE).generate()),
    ZERO(0, new ItemGenerator(Material.STAINED_GLASS_PANE, 1).setColor(DyeColor.SILVER).setName("0").generate()),
    ONE(1, new ItemGenerator(Material.STAINED_GLASS_PANE, 1).setColor(DyeColor.LIGHT_BLUE).setName("1").generate()),
    TWO(2, new ItemGenerator(Material.STAINED_GLASS_PANE, 2).setColor(DyeColor.BLUE).setName("2").generate()),
    THREE(3, new ItemGenerator(Material.STAINED_GLASS_PANE, 3).setColor(DyeColor.YELLOW).setName("3").generate()),
    FOUR(4, new ItemGenerator(Material.STAINED_GLASS_PANE, 4).setColor(DyeColor.ORANGE).setName("4").generate()),
    FIVE(5, new ItemGenerator(Material.STAINED_GLASS_PANE, 5).setColor(DyeColor.RED).setName("5").generate()),
    SIX(6, new ItemGenerator(Material.STAINED_GLASS_PANE, 6).setColor(DyeColor.BROWN).setName("6").generate()),
    SEVEN(7, new ItemGenerator(Material.STAINED_GLASS_PANE, 7).setColor(DyeColor.BLACK).setName("7").generate()),
    EIGHT(8, new ItemGenerator(Material.STAINED_GLASS_PANE, 8).setColor(DyeColor.BLACK).setName("8").generate()),
    BOMB(-1, new ItemGenerator(Material.FIREBALL, 1).setName("Boum !!!").generate());


    private int value;
    private ItemStack item;

    SquareType(int value, ItemStack item) {
        this.value = value;
        this.item = item;
    }

    public int getValue() {
        return value;
    }

    public ItemStack getItem() {
        return item;
    }


}
