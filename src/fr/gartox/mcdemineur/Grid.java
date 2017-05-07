package fr.gartox.mcdemineur;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Created by Ewan on 07/05/2017.
 */
public class Grid {

    private Square squares[][];
    private Player player;
    private Inventory inventory;

    public Grid(int y, Player player) {
        this.setSquares(new Square[9][y]);
        this.setPlayer(player);
    }

    public void open(){
        setInventory(Bukkit.createInventory(getPlayer(), this.getSquares().length, "Démineur"));
        getPlayer().openInventory(this.getInventory());
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
