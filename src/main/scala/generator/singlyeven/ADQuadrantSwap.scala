package generator.singlyeven

import model.{Matrix, Position}

/**
  * Created by sethur on 21/04/2016.
  */
class ADQuadrantSwap(matrix: Matrix) {

  val orderBy4: Int = matrix.order / 4


  def apply()={
    swapTopBoxes()
    swapMiddleBoxes()
    swapBottomBoxes()
  }


  def swapTopBoxes() = {
    val toPositionRowCol = orderBy4 - 1
    matrix.traverse(new Position(0,0), new Position(toPositionRowCol, toPositionRowCol), swap)
  }

  def swapMiddleBoxes() = {
    matrix.traverse(new Position(orderBy4, 1), new Position(orderBy4, orderBy4), swap)
  }

  def swapBottomBoxes() = {
    val fromPositionRow = orderBy4 + 1
    matrix.traverse(new Position(fromPositionRow,0), new Position(matrix.order/2 -1, orderBy4 -1), swap)
  }

  def swap: (Position) => Unit = {
    AQuadrantPosition => {
      matrix.swap(AQuadrantPosition, new Position(AQuadrantPosition.row + matrix.order / 2, AQuadrantPosition.col))
    }
  }



}
