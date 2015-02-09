package jp.com

import org.scalatest.{ShouldMatchers, FunSuite}

class CalculatorWithFixture extends FunSuite with ShouldMatchers {
  def fixture = new {
      val calculator = new Calculator
  }

  /**
   * fixtureを利用したテスト
   */
  test("add method returns added value with assertion") {
    assert(fixture.calculator.add(10) == 10)
    fixture.calculator.add(10) shouldBe (10)
  }

}
