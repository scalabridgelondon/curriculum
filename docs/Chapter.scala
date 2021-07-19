package scalabridge

import mads.Mads

trait Chapter(val title: String, val slug: String, val sections: Section*):
  def content[A](mads: Mads[A]): List[A] =
    sections.map(_.content(mads)).toList
