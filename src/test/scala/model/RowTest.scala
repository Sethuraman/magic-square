package model

import org.scalatest.FunSuite

/**
  * Created by sethur on 18/04/2016.
  */
class RowTest extends FunSuite{

  test("a new row is always initialised with columns of the same order"){
    val row = new Row(5)
    assertResult(5){row.columns.length}
    assertResult(false){row.columns.contains(null)}
  }





}
