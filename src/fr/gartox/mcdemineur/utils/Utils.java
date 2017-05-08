package fr.gartox.mcdemineur.utils;

import fr.gartox.mcdemineur.Grid;
import fr.gartox.mcdemineur.Main;
import org.bukkit.entity.Player;

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
        grids.add(new Grid(6, player));
        getGrid(player).open();
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
