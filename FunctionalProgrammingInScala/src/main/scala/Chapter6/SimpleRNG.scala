package Chapter6

/**
 * Created by JunHo on 2015. 7. 12..
 */

case class SimpleRNG(seed: Long) extends RNG {
  type Rand[+A] = RNG => (A, RNG)
  val int: Rand[Int] = _.nextInt

  def double2(rng: RNG): (Double, RNG) = {
    val (n, nextRNG) = nonNegativeInt(rng)
    val pos = (n / Int.MaxValue).toDouble

    (pos, nextRNG)
  }

  def double: Rand[Double] = map(nonNegativeInt)(n =>
    if(n == Int.MaxValue) (n-1).toDouble / Int.MaxValue
    else n.toDouble / Int.MaxValue
  )

  def unit[A](a: A): Rand[A] = rng =>(a, rng)
  def map[A,B](s: Rand[A])(f: A => B): Rand[B] =
    rng => {
      val (a,rng2) = s(rng)
      (f(a), rng2)
    }

  def nextInt: (Int, RNG) = {
    val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
    val nextRNG = SimpleRNG(newSeed)
    val n = (newSeed >>> 16).toInt
    (n, nextRNG)
  }

  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (n, nextRNG) = nextInt

    if(n < 0 || n > Int.MaxValue) nonNegativeInt(nextRNG)
    else (n, nextRNG)
  }

  def nonNegativeEven: Rand[Int] = map(nonNegativeInt)(i => i - i % 2)
}
