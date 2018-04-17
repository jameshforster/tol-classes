package storage.playerClasses

import net.minecraft.nbt.{NBTBase, NBTTagCompound}
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.Capability.IStorage

/**
  * Created by james-forster on 17/04/18.
  */
class PlayerClassesStorage extends IStorage[IPlayerClasses]{
  override def writeNBT(capability: Capability[IPlayerClasses], instance: IPlayerClasses, side: EnumFacing): NBTBase = {
    val nbt = new NBTTagCompound()
    nbt.setTag("playerClasses", instance.getClasses)
    nbt
  }

  override def readNBT(capability: Capability[IPlayerClasses], instance: IPlayerClasses, side: EnumFacing, nbt: NBTBase): Unit = {
    nbt match {
      case compound: NBTTagCompound => instance.setClasses(compound)
      case _ =>
    }
  }
}
