package fr.gartox.mcdemineur;

import fr.gartox.mcdemineur.commands.MCDemineurExecutor;
import fr.gartox.mcdemineur.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Ewan on 07/05/2017.
 */
public class Main extends JavaPlugin{
    @Override
    public void onEnable() {
        Utils.setInstance(this);
        getCommand("MCDemineur").setExecutor(new MCDemineurExecutor());
    }
}
