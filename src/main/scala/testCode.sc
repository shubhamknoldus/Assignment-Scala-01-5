val list = List(1,2,3,4,5)

val list2 = List(6,7,8,9,10)

val map1 = Map[Int, List[Int]] = Map(1 -> List(1,2,3,4,5))

list.scan()



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

def runLengthEncoding(input: List[String]):List[(String, Int)] = {
  val outputList: List[(String, Int)] = List()


  def runLengthHelper(currentString:String, count: Int,inputStringList: List[String],outputTuple: List[(String, Int)]):List[(String, Int)] = {
    inputStringList match{
      case head :: Nil => runLengthHelper(head, count, Nil, (currentString, count) :: outputTuple)
      case head :: tail =>
        if(head == currentString){
          runLengthHelper(head, count + 1, tail, outputTuple)
        } else{
          runLengthHelper(head, 1, tail, (currentString, count) :: outputTuple)
        }

      case Nil => outputTuple

    }
  }



  input match{
    case head :: tail =>
      outputList ::: runLengthHelper(head, 1, tail, outputList)
    case Nil =>
      outputList
  }
}

runLengthEncoding(List("hi", "hi", "by", "by", "hi"))
