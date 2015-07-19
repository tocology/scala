class Base { var i = 10 }; class Sub extends Base
def increment[B <: Base](b: Base) = {b.i += 1; b}
// Implicit parameter
object Doubly {
  def print(num: Double)(implicit fmt: String) = {
    println(fmt format num)
  }
}
Doubly.print(3.724)("%.1f")
case class USD(amount: Double) {
  implicit val printFmt = "%.2f"
  def print = Doubly.print(amount)
}
new USD(81.924).print
object IntUtils {
  implicit class Fishies(val x: Int){
    def fishes = "Fish" * x
  }
}
import IntUtils._
println(3.fishes)
object Test {
 implicit class ArrowAssoc[A](x: A) {
  def ->[B](y: B) = Tuple2(x,y)
  }
}
import Test._
1 -> "a"
object TypeFun {
  type Whole = Int
  val x: Whole = 5
  type UserInfo = Tuple2[Int, String]
  val u: UserInfo = new UserInfo(123, "George")

  type T3[A, B, C] = Tuple3[A, B, C]
  val things = new T3(1,'A',true)
}

val x = TypeFun.x
val u = TypeFun.u
val things = TypeFun.things

// Abstract Types
class User(val name: String)
trait Factory { type A; def create: A }
trait UserFactory extends Factory {
  type A = User
  def create = new User("")
}
// Bounded Types
class BaseUser(val name: String)
class Admin(name: String, val level: String) extends BaseUser(name)
class Customer(name: String) extends BaseUser(name)
class PreferredCustomer(name: String) extends Customer(name)
def check[A <: BaseUser](u: A) { if (u.name.isEmpty) println("Fail!")}
check(new Customer("Fred"))
check(new Admin("", "Strict"))

def recruit[A >: Customer](u: Customer): A = u match {
  case p: PreferredCustomer => new PreferredCustomer(u.name)
  case c: Customer => new Customer(u.name)
}
val customer = recruit(new Customer("Fred"))
val preferred = recruit(new PreferredCustomer("George"))

class Car { override def toString = "Car()"}
class Volvo extends Car { override def toString = "Volvo()"}
case class Item[+A](a: A) { def get: A = a }

val c: Item[Car] = new Item[Volvo](new Volvo)

c.get