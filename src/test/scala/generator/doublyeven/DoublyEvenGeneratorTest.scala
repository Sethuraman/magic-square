package generator.doublyeven

import generator.CheckValidityOfMatrix
import model.Position
import org.scalatest.FunSuite

/**
  * Created by sethur on 21/04/2016.
  */
class DoublyEvenGeneratorTest extends FunSuite{


  test("creates rectangles to place numbers in the natural order"){
    val matrix = new DoublyEvenGenerator(4)
    assertResult(matrix.listOfRectanglePositions){
      new Position(0,1)-> new Position(0,2)::
      new Position(1,3)-> new Position(2,3)::
      new Position(3,1)-> new Position(3,2)::
      new Position(1,0)-> new Position(2,0)::Nil

    }

  }


  test("creates a doubly even magic square (order is divisible by 4)"){
    val orders = 4::8::16::20::Nil
    orders.foreach(order=>{
      val matrix = new DoublyEvenGenerator(order).generate()
      matrix.print()
      CheckValidityOfMatrix(matrix)
    })
  }
}
