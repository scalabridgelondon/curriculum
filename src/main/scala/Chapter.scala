package scalabridge

import mads.Mads

trait Chapter(section: Section, sections: Section*):
  def content[A](mads: Mads[A]): List[A] =
    section.content(mads) :: sections.map(_.content(mads)).toList
