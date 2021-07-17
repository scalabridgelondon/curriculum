package scalabridge

import mads.Mads

trait Section:
  def content[A](mads: Mads[A]): A
