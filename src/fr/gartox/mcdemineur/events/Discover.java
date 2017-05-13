package fr.gartox.mcdemineur.events;

import fr.gartox.mcdemineur.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by GartoxFR on 08/05/2017.
 */
public class Discover implements Listener{

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getInventory().getName().equals("Spectate")){
            e.setCancelled(true);
            return;
        }
        if(!e.getInventory().getName().equals("Démineur") || !(e.getWhoClicked() instanceof Player) )
            return;
        if( Utils.getGrid((Player) e.getWhoClicked()) != null){
            if(e.getClick() == ClickType.LEFT){
                Player player = ((Player) e.getWhoClicked());
                Utils.getGrid(player).discover(e.getSlot());
            } else if(e.getClick() == ClickType.RIGHT){
                int x = e.getSlot() % 9;
                int y = e.getSlot() / 9;
                if( Utils.getGrid(((Player) e.getWhoClicked())).getSquares()[x][y].isFlag()){
                    Utils.getGrid(((Player) e.getWhoClicked())).getSquares()[x][y].setFlag(false);
                } else {
                    Utils.getGrid(((Player) e.getWhoClicked())).getSquares()[x][y].setFlag(true);
                }
                Utils.getGrid(((Player) e.getWhoClicked())).getSquares()[x][y].draw( Utils.getGrid(((Player) e.getWhoClicked())).getInventory());
            }
        }

        e.setCancelled(true);
    }

}
