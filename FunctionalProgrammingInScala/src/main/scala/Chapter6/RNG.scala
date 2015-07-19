package Chapter6

/**
 * Created by JunHo on 2015. 7. 12..
 */
trait RNG {
  def nextInt: (Int, RNG)
}

