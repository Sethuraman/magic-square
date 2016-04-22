package model

/**
  * Created by sethur on 18/04/2016.
  */
case class Matrix(order:Int) {

  val rows : Array[Row] = Array.fill(order)(new Row(order))


  def apply(position: Position): Option[Int] = apply(position.row, position.col)
  def apply(row:Int, col:Int): Option[Int] = rows(row).columns(col).number

  def insert(position: Position, value: Int): Unit = insert(position.row, position.col, value)
  def insert(position: Position, value: Option[Int]): Unit = insert(position.row, position.col, value)
  def insert(row: Int, col: Int, value: Int): Unit = insert(row, col, Some(value))

  def insert(row: Int, col: Int, value: Option[Int]): Unit ={
    if(row > order-1) throw new ArrayIndexOutOfBoundsException(s"row index $row is greater than allowed size $order")
    if(col > order-1) throw new ArrayIndexOutOfBoundsException(s"col index $col is greater than allowed size $order")

    rows(row).columns(col).number = value
  }

  def foreach(iterable: (Int, Int, Option[Int])=>Unit): Unit = {
    for(row <- 0 until order; col<- 0  until order){
      iterable(row, col, rows(row).columns(col).number)
    }
  }

  def traverse(from:Position, to:Position, callback: Position=>Unit): Unit ={
    for(row<-from.row to to.row; col<-from.col to to.col){
      callback(new Position(row, col))
    }
  }

  def swap(one:Position, two: Position)={
    val value = this(two)
    insert(two, this(one))
    insert(one, value)
  }

  def extractQuadrant(start: Position, end: Position) : Matrix ={
    val quadrant = new Matrix(end.row-start.row+1)
    for(row<-0 until quadrant.order; col <- 0 until quadrant.order){
      quadrant.insert(row, col, this(row+start.row, col+start.col))
    }
    quadrant
  }

  def print(): Unit ={
    rows.foreach(row=>{
      row.columns.foreach(col=>Console.printf("%5s", col.number.getOrElse("_")))
      println()
    })
  }
}






