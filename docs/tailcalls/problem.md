package tailcalls

import mads.*

trait Problem[A](mads: Mads[A]) {
  import mads.syntax.*

  val content = md"""
# The Problem That Tail Calls Solve

Let's start with an example. We'll right some simple code to sum the elements in
a list of numbers. At this point you should recognize a structural recursion
over a list.

```scala mdoc:silent
def sumOfList(list: List[Int]): Int =
  list match {
    case Nil => 0
    case hd :: tl => hd + sumOfList(tl)
  }
```

This method works as we expect if the input is small enough.

```scala mdoc
sumOfList(List())
sumOfList(List(1, 2, 3, 4, 5))
```

However, look at what happens when call it with a very large list.

```scala mdoc:silent
// This creates a list with one hundred thousand elements
val bigList = List.fill(100000)(1)
```
```scala mdoc:crash
sumOfList(bigList)
```
"""
}
