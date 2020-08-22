package net.amanso.middleclickparty;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class MiddleClickEvent {

    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent event) {
        if (!MiddleClickParty.party_bind.isPressed()) {
            return;
        }
        final MovingObjectPosition mouse = Minecraft.getMinecraft().objectMouseOver;

        MovingObjectPosition.MovingObjectType type;
        try {
            type = mouse.typeOfHit;
        }
        catch (NullPointerException e) {
            return;
        }
        if (type == MovingObjectPosition.MovingObjectType.ENTITY) {
            final Entity entity = mouse.entityHit;
            if (!(entity instanceof EntityPlayer)) {
                return;
            }
            final EntityPlayer player = (EntityPlayer) entity;
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/party invite " + player.getName());
        }
    }

}
