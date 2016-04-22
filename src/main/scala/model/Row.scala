package model

/**
  * Created by sethur on 18/04/2016.
  */
case class Row(order : Int){
  var columns : Array[Column] = Array.fill(order)(new Column(None))


}
