package handlers

import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ResourceLocation
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import storage.playerClasses.PlayerClassesProvider

/**
  * Created by james-forster on 17/04/18.
  */
class CapabilitiesHandler {

  val playerClassesResourceLocation = new ResourceLocation("tol-factions", "classes")

  @SubscribeEvent
  def attachCapability(event: AttachCapabilitiesEvent[Entity]) = {
    if (event.getObject.isInstanceOf[EntityPlayer]) {
      event.addCapability(playerClassesResourceLocation, PlayerClassesProvider)
    }
  }
}
