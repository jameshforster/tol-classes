package models

import net.minecraft.nbt.NBTTagCompound
import scala.collection.JavaConverters._

/**
  * Created by james-forster on 16/04/18.
  */
case class PlayerClassesModel(activeClass: String, classes: Seq[PlayerClassModel]) {

  def classExists(name: String) = classes.exists(_.className == name)

  def getClass(className: String) = classes.find(_.className == className)

  def updateClass(playerClassModel: PlayerClassModel) = classes.map { oldClass =>
      if (oldClass.className == playerClassModel.className) playerClassModel else oldClass
    }

  def updateOrAddClasses(playerClassModel: PlayerClassModel) = PlayerClassesModel(activeClass,
    if (classExists(playerClassModel.className)) updateClass(playerClassModel)
    else classes ++ Seq(playerClassModel)
  )

  def updateActiveClass(name: String) = {
    if (classExists(name)) PlayerClassesModel(name, classes)
    else PlayerClassesModel(name, classes ++ Seq(PlayerClassModel(name, 1, 0)))
  }

  val getActiveClass = getClass(activeClass)
}

object PlayerClassesModel {

  def classFactory = PlayerClassesModel("", Seq())

  implicit def nbtWrite: PlayerClassesModel => NBTTagCompound = playerClassesModel => {
    val nbt = new NBTTagCompound
    nbt.setString("activeClass", playerClassesModel.activeClass)
    playerClassesModel.classes.foreach { playerClassModel =>
      nbt.setTag(playerClassModel.className, playerClassModel)
    }
    nbt
  }

  implicit def nbtRead: NBTTagCompound => PlayerClassesModel = nbt => {
    val classes: Seq[Option[PlayerClassModel]] = nbt.getKeySet.asScala.toSeq.filter(_ == "activeClass").map { key =>
      PlayerClassModel.nbtRead(nbt.getCompoundTag(key))
    }

    PlayerClassesModel(nbt.getString("activeClass"), classes.flatten)
  }
}
