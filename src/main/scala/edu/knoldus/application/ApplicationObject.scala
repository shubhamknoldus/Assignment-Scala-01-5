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


  def inputHelperTwo(listOfInput: List[Int], outputList: List[Int]): List[Int] ={
    listOfInput match {
      case head :: Nil =>
        val list = obj.collatzEquationTailRecursion(head,outputList)
        list
      case head :: tail =>
        val list = obj.collatzEquationTailRecursion(head,outputList)
        inputHelperTwo(tail, list)
    }
  }

  val output = inputHelperTwo(list,lis)

  logger.info(s"\n\n$output\n\n")

}
