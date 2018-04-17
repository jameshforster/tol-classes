package mod

import java.util.concurrent.Callable

import net.minecraftforge.common.capabilities.CapabilityManager
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import proxies.CommonProxy
import storage.playerClasses.{IPlayerClasses, PlayerClasses, PlayerClassesStorage}

/**
  * Created by james-forster on 09/04/18.
  */

@Mod(modid = "tol-classes")
class Main {

  @SidedProxy(clientSide = "proxy.ClientProxy", serverSide = "proxy.ServerProxy")
  var proxy: CommonProxy = _

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) = {
    CapabilityManager.INSTANCE.register(classOf[IPlayerClasses], new PlayerClassesStorage, new Callable[PlayerClasses] {
      override def call(): PlayerClasses = new PlayerClasses
    })

    proxy.preInit(event)
  }
}
