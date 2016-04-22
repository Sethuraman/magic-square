package generator

import model.Matrix
import org.scalatest.FunSuite

import scala.collection.mutable
import scala.collection.mutable.HashSet
import scala.collection.mutable.ArrayBuffer

/**
  * Created by sethur on 19/04/2016.
  */
object CheckValidityOfMatrix extends FunSuite{

  def apply(matrix: Matrix): Unit = {
    val order:Int = matrix.order
    val sum = (order * ((order * order) + 1)) / 2

    // sum of rows
    matrix.rows.foreach(row => {
      assertResult(sum) {
        row.columns.map(_.number.getOrElse(0)).sum
      }
    })

    // sum of columns
    for (col <- 0 until order) {
      assertResult(sum) {
        (for (row <- 0 until order) yield {
          matrix(row, col).getOrElse(0)
        }).sum
      }
    }

    // sum of left diagnol
    assertResult(sum) {
      (for (rowCol <- 0 until order) yield {
        matrix(rowCol, rowCol).getOrElse(0)
      }).sum
    }

    // sum of right diagnol
    assertResult(sum) {
      (for (row <- 0 until order) yield {
        matrix(row, order-1-row).getOrElse(0)
      }).sum
    }

    //number should appear only once and all numbers
    // should appear
    val list = new mutable.ArrayBuffer[Int]
    matrix.foreach((row, col, value)=>{
      list += value.getOrElse(0)
    })

    val expectedNumbers= (1 to (order * order)).toList
    assert(expectedNumbers == list.sorted.toList)
  }
}
