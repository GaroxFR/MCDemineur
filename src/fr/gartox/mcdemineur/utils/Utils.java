package fr.gartox.mcdemineur.utils;

import fr.gartox.mcdemineur.Main;

/**
 * Created by Ewan on 07/05/2017.
 */
public class Utils {

    private static Main instance;

    public static Main getInstance(){
        return instance;
    }

    public static void setInstance(Main instance) {
        Utils.instance = instance;
    }
}
