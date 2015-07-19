package Chapter10

/**
 * Created by JunHo on 2015. 7. 11..
 */
object ImplicitClasses {
  implicit class Hello(s: String) { def hello = s"Hello, $s"}
  def test = {
    println("World".hello)
  }
}
