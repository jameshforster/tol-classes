package models

import net.minecraft.nbt.NBTTagCompound
import utils.LevelUtils

import scala.util.Try

/**
  * Created by james-forster on 09/04/18.
  */
case class PlayerClassModel(className: String, level: Int, experience: BigDecimal) {

  def levelUpAvailable(): Boolean = {
    LevelUtils.experienceBands(level).fold(false) { required =>
      experience >= required
    }
  }

  def levelUp: PlayerClassModel = {
    LevelUtils.experienceBands(level).fold(this) { required =>
      if (levelUpAvailable()) PlayerClassModel(className, level + 1, experience - required)
      else PlayerClassModel(className, level + 1, 0)
    }
  }
}

object PlayerClassModel {

  implicit def nbtWrite: PlayerClassModel => NBTTagCompound = { playerClassModel =>
    val nbt = new NBTTagCompound
    nbt.setString("className", playerClassModel.className)
    nbt.setInteger("level", playerClassModel.level)
    nbt.setDouble("experience", playerClassModel.experience.toDouble)
    nbt
  }

  implicit def nbtRead: NBTTagCompound => Option[PlayerClassModel] = { nbt =>
    Try{
      PlayerClassModel(nbt.getString("className"), nbt.getInteger("level"), nbt.getDouble("experience"))
    }.toOption
  }
}