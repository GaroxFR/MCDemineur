package fr.gartox.mcdemineur;

import fr.gartox.mcdemineur.utils.ItemGenerator;
import fr.gartox.mcdemineur.utils.SquareType;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

/**
 * Created by GartoxFR on 07/05/2017.
 */
public class Square {

    private boolean flag;
    private SquareType type;
    private boolean discover;
    private int position;
    private Inventory inventory;

    public Square(SquareType type, int position, Inventory inventory) {
        this.setType(type);
        this.setDiscover(false);
        this.setFlag(false);
        this.setPosition(position);
        this.setInventory(inventory);
    }

    public void draw(Inventory inventory) {
        if(isDiscover()){
            inventory.setItem(getPosition(), getType().getItem());
        } else {
            if(isFlag()){
                inventory.setItem(getPosition(), new ItemGenerator(Material.BANNER, 1).setName("Flag").generate());
            }else{
                inventory.setItem(getPosition(), new ItemGenerator(Material.STAINED_GLASS_PANE, 1).setColor(DyeColor.GRAY).setName("Undiscovered").generate());
            }
        }
    }

    public SquareType getType() {
        return type;
    }

    public void setType(SquareType type) {
        this.type = type;
    }

    public boolean isDiscover() {
        return discover;
    }

    public void setDiscover(boolean discover) {
        this.discover = discover;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
