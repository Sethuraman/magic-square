package generator.odd

import generator.CheckValidityOfMatrix
import model.Matrix
import org.scalatest.{BeforeAndAfter, FunSuite}

/**
  * Created by sethur on 18/04/2016.
  */
class OddOrderGeneratorTest extends FunSuite with BeforeAndAfter{

  test("should generate magic square of orders 3, 5, 25, and 37"){
    List(3,5,25,37).foreach(order => {
      val matrix: Matrix = new OddOrderGenerator(order).generate()
      println(s"Order $order")
      matrix.print()
      CheckValidityOfMatrix(matrix)
    })
  }

}
