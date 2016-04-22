package generator.odd

import model.{Matrix, Position}
import org.scalatest.FunSuite

/**
  * Created by sethur on 19/04/2016.
  */
class TopRightPositionerTest extends FunSuite{

  val matrix = new Matrix(5)
  val positioner = new TopRightPositioner(matrix)

  test("retrieves position 0,2 as the first position"){
    assertResult(new Position(0,2)){
      positioner.calculateNextPosition()
    }
  }

  test("retrieves one top then one right of last position as the next one"){
    positioner.oldPosition = Some(new Position(1,0))
    assertResult(new Position(0, 1)){
      positioner.calculateNextPosition()
    }
  }

  test("if one top puts position outside grid, it needs to wrap down. Same so with one right"){
    positioner.oldPosition = Some(new Position(0,4))
    assertResult(new Position(4, 0)){
      positioner.calculateNextPosition()
    }
  }

  test("returns one down if value is present in the one top + one right box"){
    matrix.insert(new Position(0,1), 1)
    positioner.oldPosition = Some(new Position(1, 0))
    assertResult(new Position(2,0)){
      positioner.calculateNextPosition()
    }
  }

}
