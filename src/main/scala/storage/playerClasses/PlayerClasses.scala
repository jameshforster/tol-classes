package storage.playerClasses

import models.PlayerClassesModel

/**
  * Created by james-forster on 17/04/18.
  */
trait IPlayerClasses {

  def setClasses(playerClassesModel: PlayerClassesModel): Unit
  def getClasses: PlayerClassesModel
}

class PlayerClasses extends IPlayerClasses {
  private[playerClasses] var playerClasses: PlayerClassesModel = PlayerClassesModel.classFactory

  override def setClasses(playerClassesModel: PlayerClassesModel): Unit = playerClasses = playerClassesModel

  override def getClasses: PlayerClassesModel = playerClasses
}
