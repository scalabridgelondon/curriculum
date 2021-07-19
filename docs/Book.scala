package scalabridge

final case class Book(title: String, chapters: List[Chapter])
object Book {
  val book =
    Book(
      "Working Title",
      List(scalabridge.tailcalls.TailCallsChapter)
    )
}
