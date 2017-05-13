package fr.gartox.mcdemineur.commands;

import fr.gartox.mcdemineur.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by GartoxFR on 13/05/2017.
 */
public class DSpectateExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player) || args.length == 0)
            return false;

        Player owner = ((Player) sender);
        Player player = Bukkit.getPlayer(args[0]);

        if(player == null){
            owner.sendMessage(ChatColor.GOLD + "[MCDémineur]" + ChatColor.YELLOW + "Ce joueur n'est pas connecté");
            return true;
        }

        if(!Utils.spectate(owner, player)){
            owner.sendMessage(ChatColor.GOLD + "[MCDémineur]" + ChatColor.YELLOW + "Ce joueur ne joue pas");
            return true;
        }

        return true;
    }
}
