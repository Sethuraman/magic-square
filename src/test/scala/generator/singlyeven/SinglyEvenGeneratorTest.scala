package generator.singlyeven

import generator.CheckValidityOfMatrix
import org.scalatest.FunSuite

/**
  * Created by sethur on 21/04/2016.
  */
class SinglyEvenGeneratorTest extends FunSuite{

  test("create a magic square that is singly even - divisible by 2 and not divisible by 4"){
    val orders = 6::10::14::18::Nil
    orders.foreach(order=>{
      val matrix = new SinglyEvenGenerator(order).generate()
      CheckValidityOfMatrix(matrix)
    })
  }


}
