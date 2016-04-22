import generator.Generator
import generator.doublyeven.DoublyEvenGenerator
import generator.odd.OddOrderGenerator
import generator.singlyeven.SinglyEvenGenerator

/**
  * Created by sethur on 18/04/2016.
  */
object Main {

  def main(array: Array[String]): Unit ={
    val order = checkArgsAndObtainOrder(array)
    val matrix = getGeneratorForOrder(order).generate()
    matrix.print()
  }

  def checkArgsAndObtainOrder(array: Array[String]): Int = {
    def printAndExit: Unit = {
        println("Usage: ./go.sh <order greater than 2>")
        System.exit(1)
    }

    if (array.isEmpty) printAndExit

    try{
      val order = array(0).toInt
      if(order < 3) printAndExit
      return order
    }catch{
      case notANumber: NumberFormatException => printAndExit
    }

    0
  }

  def getGeneratorForOrder(order:Int): Generator ={
    order match {
      case odd if order % 2 == 1 => new OddOrderGenerator(odd)
      case doublyeven if order % 4 == 0 => new DoublyEvenGenerator(doublyeven)
      case singlyeven => new SinglyEvenGenerator(singlyeven)
    }
  }
}
