package generator.singlyeven

import generator.Generator
import model.Matrix

/**
  * Created by sethur on 19/04/2016.
  */
class SinglyEvenGenerator(order:Int) extends Generator{

  override def generate(): Matrix = {
    val matrix = new Matrix(order)
    new ABCDQuadrants(matrix).apply()
    new ADQuadrantSwap(matrix).apply()
    new BCQuadrantSwap(matrix).apply()
    matrix
  }
}
