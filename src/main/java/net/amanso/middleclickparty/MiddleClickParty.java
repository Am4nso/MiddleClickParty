package net.amanso.middleclickparty;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = "middleclickparty", name = "MiddleClickParty", version = "@VERSION@", clientSideOnly = true, acceptedMinecraftVersions = "@MOD_ACCEPTED@")
public class MiddleClickParty {

    public static final String MODID = "middleclickparty";
    public static final String NAME = "MiddleClickParty";
    public static final String VERSION = "@VERSION@";

    public static KeyBinding party_bind;

    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        ClientRegistry.registerKeyBinding(MiddleClickParty.party_bind = new KeyBinding("Party", -98, "MiddleClickParty"));
        MinecraftForge.EVENT_BUS.register(new MiddleClickEvent());
    }

    @Mod.EventHandler
    public void postInit(final FMLPreInitializationEvent event) {
    }
}