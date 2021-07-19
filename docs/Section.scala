package scalabridge

import mads.Mads

trait Section(val title: String):
  def content[A](mads: Mads[A]): A
