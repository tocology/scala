package Chapter6

/**
 * Created by JunHo on 2015. 7. 12..
 */
object Main {
  def main(args: Array[String]) = {
    val rng = SimpleRNG(42)
    val (n1, rng2) = rng.nextInt
  }
}
