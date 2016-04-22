package generator.odd

import generator.Generator
import model.Matrix

/**
  * Created by sethur on 18/04/2016.
  */
class OddOrderGenerator(order: Int) extends Generator{

  override def generate()={
    val matrix = new Matrix(order)
    val positioner = new TopRightPositioner(matrix)

    for(number <- 1 to order*order){
      val position = positioner.calculateNextPosition()
      matrix.insert(position, number)
    }

    matrix
  }



}
