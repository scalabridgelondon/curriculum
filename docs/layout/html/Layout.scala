package scalabridge
package layout.html

import cats.implicits._
import java.io.File
import java.nio.file.Files
import mads.Mads

object Layout {
  val html = Mads(Representation)

  def write(book: Book, outputPath: File): Unit = {
    val contents = toc(book)

    book.chapters.foreach(c => writeChapter(c, contents, outputPath))
  }

  def toc(book: Book): String = {
    def chapterToc(chapter: Chapter): String =
      s"""
      |<details class="chapter">
      |  <summary>${chapter.title}</summary>
      |  <ol class="sections">
      |    ${chapter.sections.map(s => s"<li class=\"section\">${s.title}</li>").mkString("\n")}
      |  </ol>
      |</details>
      |""".stripMargin

    s"""
    |<aside class="toc w-2/5">
    |  <h1>${book.title}</h1>
    |  ${book.chapters.map(c => chapterToc(c)).mkString("\n")}
    |</aside>
    """.stripMargin
  }

  def section(section: Section): String = {
    val body = section.content(html)

    s"""
    |<div class="section">
    |  ${Representation.h1(section.title)}
    |  $body
    |</div>
    |""".stripMargin
  }

  def chapter(chapter: Chapter, toc: String): String = {
    val introduction = chapter.sections.head
    val rest = chapter.sections.tail
    val content = s"""$toc
      |<div class=\"sections\">
      |  <div class=\"section\">
      |    <h1 class=\"text-6xl font-bold pb-4\">${chapter.title}</h1>
      |    ${introduction.content(html)}
      |  </div>
      |  ${rest.map(s => section(s)).mkString("\n")}
      |</div>
      """.stripMargin

    s"""
    |<!doctype html>
    |<html>
    |<head>
    |  <meta charset="UTF-8" />
    |  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    |  <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    |  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.1.0/styles/default.min.css">
    |  <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.1.0/highlight.min.js"></script>
    |  <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.1.0/languages/scala.min.js"></script>
    |  <script>hljs.highlightAll();</script>
    |</head>
    |<body>
    |  <div class="container p-12 mx-auto flex flex-cols gap-4">
    |    $content
    |  </div>
    |</body>
    |</html>
    |""".stripMargin
  }
  def writeChapter(ch: Chapter, toc: String, outputPath: File): Unit = {
    val content = chapter(ch, toc)
    val filename = ch.slug ++ ".html"
    Files.writeString(new File(outputPath, filename).toPath, content)
  }
}
