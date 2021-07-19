package scalabridge
package layout.html

object Representation extends mads.Representation[String] {
  def h1(header: String): String =
    s"<h1 class=\"text-4xl font-bold pt-6 pb-4\">$header</h1>"

  def h2(header: String): String =
    s"<h2 class=\"text-2xl font-bold pb-4\">$header</h2>"

  def h3(header: String): String =
    s"<h3 class=\"text-xl font-bold pb-2\">$header</h3>"

  def h4(header: String): String =
    s"<h4 class=\"text-lg font-bold pb-2\">$header</h4>"

  def h5(header: String): String =
    s"<h5 class=\"font-bold pb-2\">$header</h5>"

  def h6(header: String): String =
    s"<h6 class=\"font-bold pb-2\">$header</h6>"

  def paragraph(content: String): String =
    s"<p class=\"pb-2\">$content</p>"

  def argument(a: Any): String =
    a.toString

  def text(text: String): String =
    text

  def code(language: String, content: String): String =
    s"<pre class=\"py-4\"><code class=\"language-$language\">$content</code></pre>"
}
