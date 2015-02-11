package jp.com

import org.scalatest.{ShouldMatchers, FunSuite}
import org.scalatest.prop.{TableDrivenPropertyChecks}

class CalculatorWithTableDrivenPropertyBasedTest extends FunSuite with TableDrivenPropertyChecks with ShouldMatchers {

  val numbers = 
    Table(
      ("Number"),
      (1),
      (10),
      (0),
      (10000000),
      (Integer.MIN_VALUE),
      (Integer.MAX_VALUE),
      (-1)
    )

  /**
   * TableDrivenPropertyChecks
   * 自前で用意したインプットに対するテスト
   */
  forAll ( numbers ) { (n:Int) =>
    test("add method returns added value Case: " + n) {
      val c = Calculator(0)
      assert(c.add(n) == n)
      assert(c.calculated == n)
    }
  }


}
