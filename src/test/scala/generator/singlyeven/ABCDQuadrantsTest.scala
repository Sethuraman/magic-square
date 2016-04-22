package generator.singlyeven

import generator.CheckValidityOfMatrix
import model.{Matrix, Position}
import org.scalatest.FunSuite

/**
  * Created by sethur on 20/04/2016.
  */
class ABCDQuadrantsTest extends FunSuite{

  val matrix = new Matrix(6)
  new ABCDQuadrants(matrix).apply()
  val AQuadrant = matrix.extractQuadrant(new Position(0, 0),new Position(2, 2))


  test("creates A quadrant just like an Odd Generator would"){
    CheckValidityOfMatrix(AQuadrant)
  }

  test("adds (order/2) * 2 = 9 to the first quadrant values to create the B quadrant"){
    val BQuadrant = matrix.extractQuadrant(new Position(3, 3),new Position(5, 5))
    BQuadrant.foreach((row, col, value)=> {
      assertResult(AQuadrant(row, col).map(_+9)){
        value
      }
    })
  }

  test("adds (order/2) * 6 = 18 to the first quadrant values to create the C quadrant"){
    val CQuadrant = matrix.extractQuadrant(new Position(0, 3),new Position(2, 5))
    CQuadrant.foreach((row, col, value)=> {
      assertResult(AQuadrant(row, col).map(_+18)){
        value
      }
    })
  }

  test("adds (order/2) * 9 = 27 to the first quadrant values to create the D quadrant"){
    val CQuadrant = matrix.extractQuadrant(new Position(3, 0),new Position(5, 2))
    CQuadrant.foreach((row, col, value)=> {
      assertResult(AQuadrant(row, col).map(_+27)){
        value
      }
    })
  }
}
