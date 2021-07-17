package scalabridge
package tailcalls

import mads.*

object Exercises extends Section:
  def content[A](mads: Mads[A]): A = 
    import mads.syntax.*

    md"""
# Exercises


Rewrite to use tail recursion

product of elements in a List


  def pick(idx: Int, choice: Double, weights: Array[Double]): Int =
    if (choice <= weights(idx)) idx
    else pick(idx + 1, choice, weights)
"""
