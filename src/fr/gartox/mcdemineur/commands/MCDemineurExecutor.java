package fr.gartox.mcdemineur.commands;

import fr.gartox.mcdemineur.Grid;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Ewan on 07/05/2017.
 */
public class MCDemineurExecutor implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player))
            return false;
        new Grid(9, (Player)commandSender).open();
        return true;
    }
}
