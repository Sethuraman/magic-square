package generator.singlyeven

import model.Matrix
import org.scalatest.FunSuite

/**
  * Created by sethur on 21/04/2016.
  */
class BCQuadrantSwapTest extends FunSuite{

  test("does not swap anything if order is 6 or less"){
    val list = 1 to 6
    val matrix = new Matrix(6)
    for(row <- 0 until 6){
      matrix.insert(row, 9, list(row))
    }

    new BCQuadrantSwap(matrix).apply()

    for(row <- 0 until 6){
      assert(matrix(row , 9).contains(list(row)))
    }
  }

  test("swaps the last  column of a 10 order matrix"){
    val list = 1 to 10
    val matrix = new Matrix(10)
    for(row <- 0 until 10){
      matrix.insert(row, 9, list(row))
    }

    new BCQuadrantSwap(matrix).apply()

    for(row <- 0 until 5){
      assert(matrix(row, 9).contains(list(row + 5)))
    }

    for(row <- 5 until 10){
      assert(matrix(row, 9).contains(list(row - 5)))
    }
  }

}
