package edu.knoldus.operations

import org.apache.log4j.Logger

class CollatzEquation {

  val list: List[Int] = List()

  val logger = Logger.getLogger(this.getClass)

  def collatzEquation(input: Int): List[Int] = {

    input match {
      case input if (input > 1) =>
        input match {
          case input if (input % 2 == 0) =>
            list ::: List(input) ::: collatzEquation(input / 2)
          case _ =>
            list ::: List(input) ::: collatzEquation(((3 * input) + 1))
        }
      case input if (input == 1) =>
        list ::: List(input)
    }
  }


  def collatzEquationTailRecursionWithMap(input: Int, map: Map[Int, List[Int]]): Map[Int, List[Int]] = {


    if(map.isEmpty){

      val list = List()
      map + (input -> collatzEquationTailRecursionForMap(input, list))
    }
    else {
      map + (input -> )
    }


    def checkInMap(res: Int, in: Map[Int, List[Int]]): Boolean = {
      val x = map.keySet.toList
      x.foreach(key => {
        val list = map.get(key).toList
        if(list.contains(res))
        {
          true
        }
      })
         false
    }
    /*else {
      val x = map.keySet.toList
      x.foreach(key => {
        val list = map.get(key)
        if(list.contains(input)){

        }
      })

      val listOfComputation = collatzEquationTailRecursion(input, List())

    }*/

  }



  def collatzEquationTailRecursionForMap(input: Int, outputList: List[Int]): List[Int] = {


    input match {
        case input if input > 1 =>
          input match {
            case input if input % 2 == 0 =>
              collatzEquationTailRecursionForMap(input / 2, outputList ::: List(input))
            case _ =>
              collatzEquationTailRecursionForMap((3 * input) + 1, outputList ::: List(input))
          }
        case input if (input == 1) =>
          outputList ::: List(input)

      }
  }



  def collatzEquationTailRecursion(input: Int, outputList: List[Int]): List[Int] = {

    if (outputList.contains(input)) {
      val x = outputList.indexOf(input)
      logger.info(s"$input already present in the input \n printing the remaining list from already present list ")

      for (i <- x until outputList.length) {
        logger.info(s"${outputList(i)} ")

      }
      logger.info(s"\n")
      outputList
    }
    else {
      input match {
        case input if input > 1 =>
          input match {
            case input if input % 2 == 0 =>
              collatzEquationTailRecursion(input / 2, outputList ::: List(input))
            case _ =>
              collatzEquationTailRecursion((3 * input) + 1, outputList ::: List(input))
          }
        case input if (input == 1) =>
          outputList ::: List(input)

      }
    }


  }

}
