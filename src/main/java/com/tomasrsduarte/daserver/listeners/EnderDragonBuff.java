package com.tomasrsduarte.daserver.listeners;

import com.tomasrsduarte.daserver.utils.Constants;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public record EnderDragonBuff(
        Logger logger,
        JavaPlugin plugin
) implements Listener {

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        Entity entity = event.getEntity();

        if (!(entity instanceof EnderDragon enderDragon)) {
            return;
        }

        int buffMultiplier = 2;
        int oldEnderDragonHealthBuff = plugin.getConfig().getInt(Constants.CONFIG_KEY_ENDERDRAGON_HEALTH);
        int enderDragonHealthBuff = oldEnderDragonHealthBuff * buffMultiplier;

        setEnderDragonHealth(enderDragon, enderDragonHealthBuff);

        plugin.getConfig().set(Constants.CONFIG_KEY_ENDERDRAGON_HEALTH, enderDragonHealthBuff);
    }

    private void setEnderDragonHealth(EnderDragon enderDragon, float health) {
        AttributeInstance genericMaxHealthAttribute = enderDragon.getAttribute(Attribute.GENERIC_MAX_HEALTH);

        Objects.requireNonNull(genericMaxHealthAttribute).setBaseValue(health);
        enderDragon.setHealth(health);

        logger.info("Enderdragon health has been buffed to %s".formatted(health));
    }
}
