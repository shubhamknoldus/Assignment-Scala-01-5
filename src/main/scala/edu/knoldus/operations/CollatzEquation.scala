package edu.knoldus.operations

class CollatzEquation {

  val list: List[Int] = List()

  def collatzEquation(input: Int): List[Int] = {

    input match {
      case input if (input > 1) =>
        input match {
          case input if (input % 2 == 0) =>
            list ::: List(input) ::: collatzEquation(input / 2)
          case _ =>
            list ::: List(input) ::: collatzEquation(((3 * input) + 1))
        }
      case input if(input == 1) =>
        list ::: List(input)
    }
  }

  def collatzEquationTailRecursion(input: Int, outputList: List[Int]): List[Int] = {

    input match {
      case input if (input > 1) =>
        input match {
          case input if (input % 2 == 0) =>
             collatzEquationTailRecursion(input / 2, outputList ::: List(input))
          case _ =>
             collatzEquationTailRecursion(((3 * input) + 1), outputList ::: List(input))
        }
      case input if(input == 1) =>
        outputList ::: List(1)

    }
  }

}
