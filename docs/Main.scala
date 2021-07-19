package scalabridge

import java.io.File

@main def html() = {
  scalabridge.layout.html.Layout.write(Book.book, new File("out/"))
}
