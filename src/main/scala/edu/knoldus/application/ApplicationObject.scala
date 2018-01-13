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

  logger.info(obj.collatzEquation(87))

  val list = List()

  logger.info(s"\n${obj.collatzEquationTailRecursion(96, obj.list)}")






}
