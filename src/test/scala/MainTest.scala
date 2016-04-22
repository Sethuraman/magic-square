import generator.doublyeven.DoublyEvenGenerator
import generator.odd.OddOrderGenerator
import generator.singlyeven.SinglyEvenGenerator
import org.scalatest.FunSuite

/**
  * Created by sethur on 23/04/2016.
  */
class MainTest extends FunSuite{

  test("returns a doubly even generator for an order divisible by 4"){
    assert(Main.getGeneratorForOrder(16).isInstanceOf[DoublyEvenGenerator])
  }
  test("returns an odd generator for an odd order"){
    assert(Main.getGeneratorForOrder(5).isInstanceOf[OddOrderGenerator])
  }
  test("returns a singly even generator for an order divisible by 2 and not by 4"){
    assert(Main.getGeneratorForOrder(18).isInstanceOf[SinglyEvenGenerator])
  }


}
