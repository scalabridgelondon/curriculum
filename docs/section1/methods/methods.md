package scalabridge
package section1.methods

import mads.*

object Methods extends Section
  def content[A](mads: Mads[A]): A =
    import mads.syntax.*
  
    md"""
# Methods

"""

