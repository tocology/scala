package Chapter8

/**
 * Created by JunHo on 2015. 7. 11..
 */
trait HtmlUtils {
  def removeMarkup(input: String) = {
    input
      .replaceAll("""</?\w[^>]*>""", "")
      .replaceAll("<.*>","")
  }
}
