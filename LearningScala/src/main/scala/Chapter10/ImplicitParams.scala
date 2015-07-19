package Chapter10

/**
 * Created by JunHo on 2015. 7. 11..
 */
object ImplicitParams {
  def greet(name: String)(implicit greeting: String) = s"$greeting, $name"
  implicit val hi = "hello"
  def test ={
    println(greet("Developers"))
  }
}
