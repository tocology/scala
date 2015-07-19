package Chapter8

/**
 * Created by JunHo on 2015. 7. 11..
 */
object Cat {
  def main(args: Array[String]): Unit = {
    for(arg <- args) {
      println( io.Source.fromFile(arg).mkString )
    }
  }
}
