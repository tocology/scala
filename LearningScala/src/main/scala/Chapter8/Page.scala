package Chapter8

/**
 * Created by JunHo on 2015. 7. 11..
 */
class Page(val s: String) extends SafeStringUtils with HtmlUtils{
  def asPlainText: String = {
    trimToNone(s) map removeMarkup getOrElse "n/a"
  }
}
