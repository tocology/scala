class User(val name: String) {
  def greet: String = s"Hello from $name"
  override def toString = s"User($name)"
}

val u = new User("Zeniba")

println(u.greet)
// examples of User class
val users = List(new User("Shoto"), new User("Art3mis"), new User("Aesch"))
val sizes = users map (_.name.size)
val sorted = users sortBy (_.name)
val third = users find (_.name contains "3")
val greet = third map (_.greet) getOrElse "Hi"
// inheritance and polymorphism
class A {
  def hi = "hello from A"
  override def toString = getClass.getName
}

class B extends A
class C extends B { override def hi = "hi C -> " + super.hi }
val hiA = new A().hi
val hiB = new B().hi
val hiC = new C().hi
// When we try to make a list containing all the classes that extends A
val misc = List(new C, new A, new B)
val messages =  misc.map(_.hi).distinct.sorted
// extend
class Car(var make: String, var reserved: Boolean = true,
           val year: Int = 2015) {
  override def toString = s"$year $make, reserved = $reserved"
}

class Lotus(var color: String, reserved: Boolean) extends
  Car("Lotus", reserved)

//val l = new Lotus("Silver", false)
//println(s"Requested a ${l.color} ${l.make}")

val a = new Car("Acura")
val l = new Car("Lexus", year = 2010)
//val p = new Car(reserved = false, make = "Porsche")

class Singular[A](element: A) extends Traversable[A] {
  def foreach[B](f: A => B) = f(element)
}

val p = new Singular("Planes")
p foreach println
val name = p.head
abstract class Vehicle {
  var year: Int
  var automatic: Boolean = true
  def color: String
}
//class RedMini(val year: Int) extends Vehicle {
//  def color = "Red"
//}
//val m: Vehicle = new RedMini(2005)

// Anonymous Classes
abstract class Listener { def trigger }
var myListener = new Listener {
  def trigger: Unit = {
    println(s"Trigger at ${new java.util.Date}")
  }
}
myListener.trigger

class Listening {
  var listener: Listener = null
  def register(l: Listener) { listener = l }
  def sendNotification() { listener.trigger }
}

val notification = new Listening()
notification.register(new Listener {
  def trigger { println(s"Trigger at ${new java.util.Date}")}
})
notification.sendNotification

// Overloaded Methods
class Printer(msg: String) {
  def print(s: String): Unit = println(s"$msg: $s")
  def print(l: Seq[String]): Unit = print(l.mkString(", "))
}
new Printer("Today's Report").print("Foggy" :: "Rainy" :: "Hot" :: Nil)

// Apply Methods
class Multiplier(factor: Int) {
  def apply(input: Int) = input * factor
}
val tripleMe = new Multiplier(3)
val tripled = tripleMe.apply(10)
val tripled2 = tripleMe(10)

// lazy
class RandomPoint {
  val x = { println("creating x"); util.Random.nextInt}
  lazy val y = { println("now y"); util.Random.nextInt}
}

val pp = new RandomPoint()
println(s"Location is ${pp.x}, ${pp.y}")
println(s"Location is ${pp.x}, ${pp.y}")

// Privacy Controls
class User2(private var password: String) {
  def update(p: String): Unit ={
    println("Modifying the password!")
    password = p
  }
  def validate(p: String) = p == password
}
val u2 = new User2("1234")
val isValid = u2.validate("4567")
u2.update("4567")
val isValid2 = u2.validate("4567")


object HtmlUnits {
  def removeMarkup(input: String) = {
    input.replaceAll("""</?\w[^>]*>""","")
        .replaceAll("<.*>","")
  }
}
val html = "<html><body><h1>Introduction</h1></body></html>"
val text = HtmlUnits.removeMarkup(html)

// companion object
object DBConnection {
  private val db_url = "jdbc://localhost"
  private val db_user = "franken"
  private val db_pass = "berry"

  def apply() = new DBConnection
}
class DBConnection {
  private val props = Map(
    "url" -> DBConnection.db_url,
    "user" -> DBConnection.db_user,
    "pass" -> DBConnection.db_pass
  )
  println(s"Created new connection for " + props("url"))
}

val conn = DBConnection()

class TestSuite(suiteName: String) { def start() {} }

trait RandomSeeded { self: TestSuite =>
  def randomStart(): Unit = {
    util.Random.setSeed(System.currentTimeMillis())
    self.start()
  }
}

class IdSpec extends TestSuite("ID Tests") with RandomSeeded {
  def testId() { println(util.Random.nextInt != 1 )}
  override def start() { testId() }

  println("Starting...")
  randomStart()
}

new IdSpec()

case class Receipt(id: Int, amount: Double, who: String, title: String)

val latteReceipt = Receipt(123, 4.12, "fred", "Medium Latte")
import latteReceipt._
println(s"Sold a $title for $amount to $who")

