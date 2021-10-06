package com.mattmx.witherremoval;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Witherremoval extends JavaPlugin {
    static Witherremoval instance;
    public static String PRE = "&#0e0000&o&lW&#1c0000&o&lI&#2b0000&o&lT&#390000&o&lH&#470000&o&lE&#560000&o&lR&#640000&o&lC&#720000&o&lL&#810000&o&lE&#8f0000&o&lA&#9e0000&o&lR";

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        Bukkit.getPluginCommand("clearwither").setExecutor(new Command());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Witherremoval getInstance() {
        return instance;
    }
}
