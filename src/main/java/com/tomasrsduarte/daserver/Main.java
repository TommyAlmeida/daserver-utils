package com.tomasrsduarte.daserver;

import com.tomasrsduarte.daserver.listeners.EnderDragonBuff;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private Logger logger;

    public void onLoad() {
        logger = Logger.getLogger("DaServer");
    }

    public void onEnable() {
        saveDefaultConfig();
        registerEvents(new EnderDragonBuff(logger, this));
    }

    private void registerEvents(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }
    }


}
