package Chapter6

import org.scalatest.{Matchers, FunSuite}

/**
 * Created by JunHo on 2015. 7. 12..
 */
class Chapter6Spec extends FunSuite with Matchers {
  test("nonNegativeInt test") {
    val rng1 = SimpleRNG(42)

    val (n1, rng2) = rng1.nonNegativeInt(rng1)

    n1 should be >0
  }
}
