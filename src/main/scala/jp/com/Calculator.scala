package jp.com

case class Calculator (calculatedDefault:Int) {

  def this() {
    this(0)
  }

  var calculated = calculatedDefault
  var addedHistory:List[Int] = List()

  def add(x:Int):Int = {
    addedHistory = x :: addedHistory
    calculated += x
    calculated
  }

  override def toString:String = "Calculated History : " + addedHistory.mkString(", ")
}
