package proxies
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent, FMLServerStartingEvent}

/**
  * Created by james-forster on 17/04/18.
  */
class ClientProxy extends CommonProxy {
  override def preInit(event: FMLPreInitializationEvent): Unit = {
    super.preInit(event)
  }

  override def init(event: FMLInitializationEvent): Unit = {
    super.init(event)
  }

  override def serverStarting(event: FMLServerStartingEvent): Unit = {
    super.serverStarting(event)
  }

  override def postInit(event: FMLPostInitializationEvent): Unit = {
    super.postInit(event)
  }
}
