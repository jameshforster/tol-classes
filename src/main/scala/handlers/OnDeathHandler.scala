package handlers

import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import storage.playerClasses.{IPlayerClasses, PlayerClassesProvider}

/**
  * Created by james-forster on 17/04/18.
  */
class OnDeathHandler {

  @SubscribeEvent
  def onPlayerClone(event: PlayerEvent.Clone) = {
    val classes = event.getEntityPlayer.getCapability[IPlayerClasses](PlayerClassesProvider.playerClassesCapability, null)
    val oldClasses = event.getOriginal.getCapability(PlayerClassesProvider.playerClassesCapability, null)

    classes.setClasses(oldClasses.getClasses)
  }
}
