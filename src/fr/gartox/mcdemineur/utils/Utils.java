package fr.gartox.mcdemineur.utils;

import fr.gartox.mcdemineur.Grid;
import fr.gartox.mcdemineur.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by GartoxFR on 07/05/2017.
 */
public class Utils {

    private static Main instance;
    private static List<Grid>grids = new ArrayList<Grid>();

    public static Main getInstance(){
        return instance;
    }

    public static void setInstance(Main instance) {
        Utils.instance = instance;
    }

    public static void createGrid(Player player){
        grids.add(new Grid(9, player));
        getGrid(player).open();
    }

    public static void removeGrid(Player player){
        for(int i = 0 ; i < grids.size() ; i++){
            if(grids.get(i).getPlayer().equals(player))grids.remove(grids.get(i));
        }
    }

    public static boolean spectate(Player owner, Player player){
        if(getGrid(player) == null)return false;

        Inventory inventory = Bukkit.createInventory(owner, 9*9, "Spectate");
        Utils.getGrid(player).addSpectator(inventory, owner);

        return true;
    }

    public static Grid getGrid(Player player){
        for(Grid grid : grids){
            if(grid.getPlayer().equals(player))
                return grid;
        }
        return null;
    }
    public static SquareType getType(int value){
        for(SquareType st : SquareType.values()){
            if(st.getValue() == value) return st;
        }
        return null;
    }
}
