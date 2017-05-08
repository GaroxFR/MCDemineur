package fr.gartox.mcdemineur.commands;

import fr.gartox.mcdemineur.Grid;
import fr.gartox.mcdemineur.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by GartoxFR on 07/05/2017.
 */
public class MCDemineurExecutor implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player))
            return false;
        Utils.createGrid((Player)sender);
        return true;
    }
}
