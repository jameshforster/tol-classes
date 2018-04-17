package proxies

import handlers.{CapabilitiesHandler, OnDeathHandler}
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent, FMLServerStartingEvent}

/**
  * Created by james-forster on 17/04/18.
  */
trait CommonProxy {

  def preInit(event: FMLPreInitializationEvent): Unit

  def init(event: FMLInitializationEvent): Unit = {
    MinecraftForge.EVENT_BUS.register(new CapabilitiesHandler)
    MinecraftForge.EVENT_BUS.register(new OnDeathHandler)
  }

  def postInit(event: FMLPostInitializationEvent): Unit

  def serverStarting(event: FMLServerStartingEvent): Unit
}
