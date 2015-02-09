package jp.com

import org.scalatest.{ShouldMatchers, FunSuite}

/**
 * xUnit形式のテスト
 * http://www.scalatest.org/user_guide/selecting_a_style
 * におけるFunSuite
 */
class CalculatorTest extends FunSuite with ShouldMatchers{

  /**
   * 普通のUnitテスト
   */
  test("add method returns added value with assertion") {
    val c = Calculator(0)
    assert(c.add(10) == 10)
    assert(c.calculated ==10)
  }

  /**
   * trait ShouldMatchersを利用したUnitテスト
   */
  test("add method returns added value with should matchers") {
    val c = Calculator(0)
    c.add(10) shouldBe (10)
    c.calculated shouldBe (10)
  }

  /**
   * http://www.scalatest.org/user_guide/using_matchers
   */
  test("add method returns added value with should matchers on various patterns") {
    val c = Calculator(0)
    c.add(10)
    c.calculated should equal (10)
    c.calculated should === (10)
    c.calculated should be (10)
    c.calculated shouldEqual 10
    c.calculated shouldBe (10)
  }

  test("added history size is correct with should matchers") {
    val c = Calculator(0)
    c.add(10)
    c.addedHistory should have size 1
    c.addedHistory should have length 1
  }

  test("toString returns correct Message with should matchers") {
    val c = Calculator(0)
    c.add(10)
    c.toString should startWith ("Calculated")
    c.toString should endWith ("10")
    c.toString should include ("History")

    c.toString should startWith regex "Calc.lated"
    c.toString should endWith regex "1."
    c.toString should include regex ".istory"
  }
}
