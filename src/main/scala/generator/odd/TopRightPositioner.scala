package generator.odd

import model.{Matrix, Position}

/**
  * Created by sethur on 19/04/2016.
  */
class TopRightPositioner(val matrix: Matrix) {

  var oldPosition : Option[Position] = None

  def calculateNextPosition(): Position = {
    val newPosition = oldPosition.map(nextPosition).getOrElse(new Position(0, matrix.order / 2))
    oldPosition = Some(newPosition)
    newPosition
  }

  def nextPosition(oldPosition: Position) :Position ={
    var newPosition = new Position(nextRow(oldPosition.row), nextCol(oldPosition.col))
    newPosition = matrix(newPosition) match{
      case Some(number) => new Position(oldPosition.row+1, oldPosition.col)
      case None=> newPosition
    }
    newPosition
  }


  private def nextRow(row : Int): Int ={
    val oneTop = row - 1
    if(oneTop < 0) return matrix.order-1
    oneTop
  }

  private def nextCol(col: Int): Int = (col + 1) % matrix.order

}
