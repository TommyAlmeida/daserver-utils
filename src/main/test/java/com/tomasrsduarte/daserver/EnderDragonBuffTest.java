package com.tomasrsduarte.daserver;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.plugin.PluginManagerMock;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnderDragonBuffTest {

    private ServerMock server;
    private PluginManagerMock pluginManager;
    private Main plugin;

    @BeforeEach
    public void setUp() {
        server = MockBukkit.mock();
        pluginManager = server.getPluginManager();
        plugin = MockBukkit.load(Main.class);
    }

    @AfterEach
    public void tearDown()
    {
        MockBukkit.unmock();
    }

    @Test
    public void assertEventFired_EventWasNotFired_Asserts()
    {
        pluginManager.assertEventFired(CreatureSpawnEvent.class);
    }
}
