package generator.singlyeven

import generator.odd.OddOrderGenerator
import model.{Matrix, Position}

/**
  * Created by sethur on 20/04/2016.
  */
class ABCDQuadrants(matrix: Matrix) {

  val order = matrix.order
  val halfOrder = order / 2
  val halfOrderMatrixMaxNumber = halfOrder * halfOrder

  def apply(): Unit ={
    val AQuadrant = new OddOrderGenerator(halfOrder).generate()
    AQuadrant.foreach((matrixRow, matrixCol, value)=> {
      matrix.insert(matrixRow, matrixCol, value)
      matrix.insert(transposeToBQuadrant(matrixRow, matrixCol), value.map( _ + halfOrderMatrixMaxNumber))
      matrix.insert(transposeToCQuadrant(matrixRow, matrixCol), value.map( _ + halfOrderMatrixMaxNumber * 2))
      matrix.insert(transposeToDQuadrant(matrixRow, matrixCol), value.map( _ + halfOrderMatrixMaxNumber * 3))
    })
  }

  def transposeToBQuadrant(matrixRow: Int, matrixCol: Int) = new Position(matrixRow + halfOrder, matrixCol + halfOrder)
  def transposeToCQuadrant(matrixRow: Int, matrixCol: Int) = new Position(matrixRow , matrixCol + halfOrder)
  def transposeToDQuadrant(matrixRow: Int, matrixCol: Int) = new Position(matrixRow + halfOrder , matrixCol)

}
