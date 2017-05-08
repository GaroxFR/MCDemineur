package fr.gartox.mcdemineur.events;

import fr.gartox.mcdemineur.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by GartoxFR on 08/05/2017.
 */
public class Discover implements Listener{

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getInventory().getName() != "Démineur" || !(e.getWhoClicked() instanceof Player) || Utils.getGrid((Player)e.getWhoClicked()) == null || !(e.getInventory().equals(Utils.getGrid((Player)e.getWhoClicked()).getInventory())))
            return;
        Player player = ((Player) e.getWhoClicked());
        Utils.getGrid(player).discover(e.getSlot());
        e.setCancelled(true);
    }

}
