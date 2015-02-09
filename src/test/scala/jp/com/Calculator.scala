package jp.com

import org.scalatest.FunSuite

class CalculatorTest extends FunSuite {
  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }
}
