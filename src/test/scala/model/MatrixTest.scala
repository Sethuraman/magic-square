package model

import org.scalatest.FunSuite

/**
  * Created by sethur on 18/04/2016.
  */
class MatrixTest extends FunSuite{

  test("a new matrix is always initialised with row elements"){
    val matrix = new Matrix(5)
    assertResult(5){matrix.rows.length}
    assertResult(false){matrix.rows.contains(null)}
  }

  test("returns None in position if not present"){
    val matrix = new Matrix(5)
    assertResult(None){
      matrix(new Position(0, 0))
    }
  }

  test("returns Some(value) in position if present"){
    val matrix = new Matrix(5)
    matrix.rows.head.columns(0).number=Some(12)
    assertResult(Some(12)){
      matrix(new Position(0, 0))
    }
  }

  test("sets a value in the position"){
    val matrix = new Matrix(5)
    matrix.insert(new Position(0,0), 12)
    assertResult(Some(12)){
      matrix(new Position(0,0))
    }
  }

  test("swaps the values in the matrix"){
    val matrix = new Matrix(3)
    matrix.insert(0,0, 2)
    matrix.insert(1,1, 3)
    matrix.swap(new Position(0,0), new Position(1,1))
    assertResult(Some(3)){
      matrix(0,0)
    }
    assertResult(Some(2)){
      matrix(1,1)
    }
  }



}
