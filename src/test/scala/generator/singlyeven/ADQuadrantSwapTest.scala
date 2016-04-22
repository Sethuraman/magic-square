package generator.singlyeven

import model.Matrix
import org.scalatest.FunSuite

/**
  * Created by sethur on 21/04/2016.
  */
class ADQuadrantSwapTest extends FunSuite{

  val matrix = new Matrix(6)
  new ABCDQuadrants(matrix).apply()
  new ADQuadrantSwap(matrix).apply()

  test("should swap first box of A and D quadrants"){
    assert(matrix(0, 0).contains(35))
    assert(matrix(3, 0).contains(8))
  }

  test("should swap middle box of A and D quadrants"){
    assert(matrix(1, 1).contains(32))
    assert(matrix(4, 1).contains(5))
  }

  test("should swap first bottom box of A and D quadrants"){
    assert(matrix(2, 0).contains(31))
    assert(matrix(5, 0).contains(4))
  }

}
