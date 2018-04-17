package models

import helpers.UnitSpec
import utils.LevelUtils

/**
  * Created by james-forster on 09/04/18.
  */
class PlayerClassModelSpec extends UnitSpec {

  "Calling levelAvailable" when {

    "provided with a class of level 9" should {
      val required = LevelUtils.experienceBands(9).get

      "return a value of true when experience is greater than requirements" in {
        PlayerClassModel("", 9, required + 0.01).levelUpAvailable() shouldBe true
      }

      "return a value of true when experience is equal to requirements" in {
        PlayerClassModel("", 9, required).levelUpAvailable() shouldBe true
      }

      "return a value of false when experience is less than requirements" in {
        PlayerClassModel("", 9, required - 0.01).levelUpAvailable() shouldBe false
      }
    }

    "provided with a class of level 1" should {
      val required = LevelUtils.experienceBands(1).get

      "return a value of true when experience is greater than requirements" in {
        PlayerClassModel("", 1, required + 0.01).levelUpAvailable() shouldBe true
      }

      "return a value of true when experience is equal to requirements" in {
        PlayerClassModel("", 1, required).levelUpAvailable() shouldBe true
      }

      "return a value of false when experience is less than requirements" in {
        PlayerClassModel("", 1, required - 0.01).levelUpAvailable() shouldBe false
      }
    }

    "provided with a class of level 0" should {

      "always return a value of false" in {
        PlayerClassModel("", 0, 1000000).levelUpAvailable() shouldBe false
      }
    }

    "provided with a class of level 10" should {

      "always return a value of false" in {
        PlayerClassModel("", 10, 1000000).levelUpAvailable() shouldBe false
      }
    }
  }

  "Calling levelUp" when {

    "provided with a class at the maximum level" should {

      "return the class at the same level" in {
        PlayerClassModel("", 10, 500).levelUp shouldBe PlayerClassModel("", 10, 500)
      }
    }

    "provided with a class below the minimum level" should {

      "return the class at the same level" in {
        PlayerClassModel("", 0, 250).levelUp shouldBe PlayerClassModel("", 0, 250)
      }
    }

    "provided with a class of level 9" when {
      val required = LevelUtils.experienceBands(9).get

      "there is not enough experience to level" should {

        "return a levelled up class with no experience" in {
          PlayerClassModel("", 9, required - 0.01).levelUp shouldBe PlayerClassModel("", 10, 0)
        }
      }

      "there is just enough experience to level" should {

        "return a levelled up class with no experience" in {
          PlayerClassModel("", 9, required).levelUp shouldBe PlayerClassModel("", 10, 0)
        }
      }

      "there is more than enough experience to level" should {

        "return a levelled up class with the remaining experience" in {
          PlayerClassModel("", 9, required + 0.01).levelUp shouldBe PlayerClassModel("", 10, 0.01)
        }
      }
    }

    "provided with a class of level 1" when {
      val required = LevelUtils.experienceBands(1).get

      "there is not enough experience to level" should {

        "return a levelled up class with no experience" in {
          PlayerClassModel("", 1, required - 0.01).levelUp shouldBe PlayerClassModel("", 2, 0)
        }
      }

      "there is just enough experience to level" should {

        "return a levelled up class with no experience" in {
          PlayerClassModel("", 1, required).levelUp shouldBe PlayerClassModel("", 2, 0)
        }
      }

      "there is more than enough experience to level" should {

        "return a levelled up class with the remaining experience" in {
          PlayerClassModel("", 1, required + 0.01).levelUp shouldBe PlayerClassModel("", 2, 0.01)
        }
      }
    }
  }
}
