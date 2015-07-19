package Chapter8

/**
 * Created by JunHo on 2015. 7. 11..
 */
trait SafeStringUtils {

  def trimToNone(s: String): Option[String] = {
    Option(s) map(_.trim) filterNot(_.isEmpty)
  }
}
