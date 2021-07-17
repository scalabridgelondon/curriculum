package scalabridge
package tailcalls

import mads.*

object Intro extends Section:
  def content[A](mads: Mads[A]): A = 
    import mads.syntax.*

    md"""
# Introduction

In this section we'll learn about *tail calls*. Knowing about tail calls is
important for creating code that works on large amounts of data, or when
performance is important, but it isn't a concern in most day-to-day programming.

Here's the plan:

- To start we will see an example that shows the problem that tail calls solve;
- We'll then extend our notional machine model so we can understand how the problem arises;
- We'll introduce tail calls, and the `@tailcall` annotation in Scala, to solve the problem; and
- Finally, we'll discuss some of the more advanced techniques associated with tail calls.
"""
