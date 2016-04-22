package generator.singlyeven

import model.{Matrix, Position}

/**
  * Created by sethur on 21/04/2016.
 */
class BCQuadrantSwap(matrix: Matrix) {

  def apply(): Unit = {
    val noOfColumnsToSwap = matrix.order / 4 - 1
    if(noOfColumnsToSwap<=0) return

    matrix.traverse(new Position(0, matrix.order - noOfColumnsToSwap), new Position(matrix.order/2 -1, matrix.order - 1),
      position => {
        matrix.swap(position, new Position(position.row + matrix.order/2, position.col))
      })
  }

}
