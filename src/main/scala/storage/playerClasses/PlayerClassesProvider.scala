package storage.playerClasses

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.{Capability, CapabilityInject, ICapabilitySerializable}

/**
  * Created by james-forster on 17/04/18.
  */
object PlayerClassesProvider extends ICapabilitySerializable[NBTTagCompound] {

  @CapabilityInject(classOf[IPlayerClasses])
  var playerClassesCapability: Capability[IPlayerClasses] = _

  private val instance: IPlayerClasses = playerClassesCapability.getDefaultInstance

  override def deserializeNBT(nbt: NBTTagCompound): Unit = playerClassesCapability.getStorage.readNBT(playerClassesCapability, instance, null, nbt)

  override def serializeNBT(): NBTTagCompound = playerClassesCapability.getStorage.writeNBT(playerClassesCapability, instance, null).asInstanceOf[NBTTagCompound]

  override def getCapability[T](capability: Capability[T], facing: EnumFacing): T = {
    if (hasCapability(capability, facing)) instance else null
  }.asInstanceOf[T]

  override def hasCapability(capability: Capability[_], facing: EnumFacing): Boolean = {
    capability == playerClassesCapability
  }
}
