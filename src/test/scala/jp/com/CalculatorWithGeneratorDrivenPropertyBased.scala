package jp.com

import org.scalatest.{ShouldMatchers, FunSuite}
import org.scalatest.prop.{GeneratorDrivenPropertyChecks}

class CalculatorWithGeneratorDrivenPropertyBasedTest extends FunSuite with GeneratorDrivenPropertyChecks with ShouldMatchers {
  /**
   * testの回数
   */
  var count = 0

  /**
   * GeneratorDrivenPropertyChecks
   * 任意のインプットに対するテスト
   */
  forAll { (n:Int) =>
    count = count + 1
    test("add method returns added value Case: " + n + " : " + count ) {
      val c = Calculator(0)
      assert(c.add(n) == n)
      assert(c.calculated == n)
    }
  }
}
