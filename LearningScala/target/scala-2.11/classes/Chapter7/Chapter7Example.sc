val colors = Array("red", "green", "blue")

println("very purple: " + colors)
val files = new java.io.File(".").listFiles
val scala = files map (_.getName) filter(_ endsWith "policy")
def inc(i: Int): Stream[Int] = Stream.cons(i, inc(i+1))
val s = inc(1)
def to(head: Char, end: Char): Stream[Char] = (head > end) match {
  case true => Stream.empty
  case false => head #:: to((head+1).toChar, end)
}

val hexChars = to('A', 'F').take(20).toList
def divide(amt: Double, divisor: Double): Option[Double] = {
  if(divisor == 0) None
  else Option(amt / divisor)
}

val legit = divide(5,2)
val odds = List(1,3,5)
val firstOdd = odds.headOption
val evens = odds filter (_ % 2 == 0)
val firstEven = evens.headOption
val words = List("risible", "scavenger", "gist")
val uppercase = words find (w => w == w.toUpperCase())
val lowercase = words find (w => w == w.toLowerCase())
def nextOption = if (util.Random.nextInt > 0) Some(1) else None
val a = nextOption
val b = nextOption
nextOption getOrElse 5
nextOption getOrElse {
  println("error"); -1
}

def loopAndFail(end: Int, failAt: Int): Int = {
  for( i <- 1 to end){
    println(s"$i) ")
    if(i == failAt) throw new Exception("Too many iterations")
  }
  end
}

val t1 = util.Try( loopAndFail(2, 3))
val t2 = util.Try( loopAndFail(4,2))
def nextError = util.Try{ 1 / util.Random.nextInt(2)}
val x = nextError
val y = nextError
nextError flatMap { _ => nextError}
nextError foreach( x => println("success" + x))
nextError map ( x => x * 2)
val input = " 123 "
val result = util.Try(input.toInt) orElse util.Try(input.trim.toInt)
result foreach { r => println(s"Parsed '$input' to $r!")}
val x1 = result match {
  case util.Success(x) => Some(x)
  case util.Failure(ex) => {
    println(s"Couldn't parse input '$input'")
    None
  }
}
import concurrent.ExecutionContext.Implicits.global
import concurrent.Future

def cityTemp(name: String): Double = {
  val url = "http://api.openweathermap.org/data/2.5/weather"
  val cityUrl = s"$url?q=$name"
  val json = io.Source.fromURL(cityUrl).mkString.trim
  val pattern = """.*"temp":([\d.]+).*""".r
  val pattern(temp) = json
  temp.toDouble
}

val cityTemps = Future sequence Seq(
  Future(cityTemp("Fresno")), Future(cityTemp("Tempe"))
)

cityTemps onSuccess {
  case Seq(x,y) if x > y => println(s"Fresno is warmer: $x K")
  case Seq(x,y) if y > x => println(s"Tempe is warmer: $y K")
}

