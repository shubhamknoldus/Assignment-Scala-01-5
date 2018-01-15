package edu.knoldus.application

import edu.knoldus.operations.CollatzEquation
import org.apache.log4j.Logger

object ApplicationObject extends App {

  val logger = Logger.getLogger(this.getClass)
  val obj = new CollatzEquation

  val arg1 = 23
  val arg2 = 47
  val arg3 = 50
  val arg4 = 87
  val arg5 = 17
  val arg6 = 96

  val list = List(arg1, arg3, arg4, arg5, arg6)

  val lis: List[Int] = List()
  val listMap: Map[Int, List[Int]] = Map()



 /* def inputHelperMap(inputMap: Map[Int, List[Int]], inputList: List[Int]): Map[Int, List[Int]] = {


    inputList match {
      case first :: rest =>
       // val list = obj.collatzEquationTailRecursion(first)

        inputMap + Map(first -> )
    }

  }*/


  logger.info(obj.collatzEquationTailRecursionWithMap(arg1, listMap) + "\n\n\n")

  def inputHelper(input: List[List[Int]]): List[Int] = {

    /*input(0) match {
      case head :: tail =>
        inputHelper(List(tail, input(1) ::: obj.collatzEquationTailRecursion(head, lis)))
      case Nil =>
        input(1)
    }*/
    input match {
      case head :: head2 :: tail =>
        head match {
          case first :: rest =>
            inputHelper(List(rest, head2 ::: obj.collatzEquationTailRecursion(first, lis)))
          case Nil =>
            head2
        }
    }

  }


  val output = inputHelper(List(list, lis))

  logger.info(s"\n\n$output\n\n")
  //why these code not working

  //  list.map(s => lis ::: obj.collatzEquationTailRecursion(s, lis))

  /*
    logger.info(lis ::: obj.collatzEquationTailRecursion(arg6, lis))

    logger.info(obj.collatzEquation(arg4))


    logger.info(s"\n${obj.collatzEquationTailRecursion(arg6, obj.list)}")*/


}
