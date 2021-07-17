package scalabridge
package tailcalls

import mads.*

object TailCalls extends Section:
  def content[A](mads: Mads[A]): A = 
    import mads.syntax.*

    md"""
# Tail Calls

We've just learned about the stack and seen that long recursive calls can cause
it to run out of space. However, we know we can solve this problem with what is
called a tail recursive method. Here's the example we saw earlier.

```scala mdoc:silent
def sumOfListTailRec(list: List[Int], total: Int): Int =
  list match {
    case Nil => total
    case hd :: tl => sumOfListTailRec(tl, total + hd) 
  }
```

Let's perform substitution on `sumOfListTailRec(List(1, 2, 3, 4, 5), 0)`.

A few steps get us to

```scala
sumOfListTailRec(List(2, 3, 4, 5), 1)
```

After some more steps we'll get to

```scala
sumOfListTailRec(List(4, 5), 6)
```

Finally we get to

```scala
sumOfListTailRec(List(), 15)
```

which terminates the recursion.

Notice in this use of substitution we never have any computation waiting
pattern: pass state

@tailrec

Mutual recursion
"""

