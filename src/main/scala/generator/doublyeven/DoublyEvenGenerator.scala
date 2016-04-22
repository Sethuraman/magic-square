package generator.doublyeven

import generator.Generator
import model.{Matrix, Position}

import scala.collection.mutable

/**
  * Created by sethur on 21/04/2016.
  */
class DoublyEvenGenerator(order: Int) extends Generator{

  val matrix = new Matrix(order)

  val orderBy2 = order/2
  val orderBy4 = order/4

  val listOfRectanglePositions:List[(Position,Position)] = {
    new Position(0, orderBy4)->new Position(orderBy4-1, orderBy4+orderBy2-1) ::
    new Position(orderBy4,orderBy2+orderBy4)->new Position(orderBy4+orderBy2-1, order-1) ::
    new Position(orderBy4+orderBy2,orderBy4)->new Position(order-1, orderBy4+orderBy2-1) ::
    new Position(orderBy4,0)->new Position(orderBy4+orderBy2-1, orderBy4-1) ::
    Nil
  }


  override def generate(): Matrix = {
    val populatedNumbers = populateNumbersInRectangle()
    populateNumbersInOtherCells(populatedNumbers)
    matrix
  }


  def indexFallsInRectangle(row: Int, col: Int): Boolean = {
    listOfRectanglePositions.exists((rectangle)=>{
      row >= rectangle._1.row && row <= rectangle._2.row &&
      col >= rectangle._1.col && col <= rectangle._2.col
    })
  }

  def calculateNumberInCell(row: Int, col: Int) = (row * order) + col + 1


  def populateNumbersInOtherCells(populatedNumbers: mutable.HashSet[Int]) = {
    var numberToPopulate = order * order

    def getNextNumber() : Int = {
      while(populatedNumbers.contains(numberToPopulate)){
        numberToPopulate -= 1
      }
      numberToPopulate
    }

    matrix.foreach((row, col, value)=>{
      if(value.isEmpty) {
        matrix.insert(row, col, getNextNumber())
        numberToPopulate -= 1
      }
    })
  }

  def populateNumbersInRectangle() = {
    var populatedNumbers = new mutable.HashSet[Int]
    matrix.foreach((row, col, value) => {
      if (indexFallsInRectangle(row, col)) {
        val numberInCell = calculateNumberInCell(row, col)
        populatedNumbers += numberInCell
        matrix.insert(row, col, numberInCell)
      }
    })
    populatedNumbers
  }
}
