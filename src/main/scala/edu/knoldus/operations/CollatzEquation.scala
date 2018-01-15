package edu.knoldus.operations

import org.apache.log4j.Logger

class CollatzEquation {

  val list: List[Int] = List()

  val logger = Logger.getLogger(this.getClass)

  def collatzEquation(input: Int): List[Int] = {

    input match {
      case input if input > 1 =>
        input match {
          case input if input % 2 == 0 =>
            list ::: List(input) ::: collatzEquation(input / 2)
          case _ =>
            list ::: List(input) ::: collatzEquation(((3 * input) + 1))
        }
      case input if input == 1 =>
        list ::: List(input)
    }
  }


  def collatzEquationTailRecursion(input: Int, outputList: List[Int]): List[Int] = {

    if(listContains(outputList, input)){
      outputList
    } else{
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


  def listContains(listToCheck: List[Int], numberToCheck: Int): Boolean ={

    listToCheck match {
      case Nil =>
        false
      case head :: Nil => if(head == numberToCheck){
        true
      } else{
        false
      }
      case head :: tail =>
        if(head == numberToCheck){
          true
        } else{
          listContains(tail, numberToCheck)
        }

    }
  }

}
