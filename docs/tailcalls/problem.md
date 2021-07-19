package scalabridge
package tailcalls

import mads.*

object Problem extends Section("The Problem that Tail Calls Solve"):
  def content[A](mads: Mads[A]): A = 
    import mads.syntax.*

    md"""
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
```scala
sumOfList(bigList)
// java.lang.StackOverflowError
// 	at scala.collection.immutable.List.equals(List.scala:612)
//    <Lots more output that we have deleted>
```

We get a `StackOverflowError` which crashes the program. We will see this
problem in many recursive programs when working on large data. Luckily we can
solve this with a tail recursive method! Here's an example.

```scala mdoc:silent
def sumOfListTailRec(list: List[Int], total: Int): Int =
  list match {
    case Nil => total
    case hd :: tl => sumOfListTailRec(tl, total + hd) 
  }
```

When we call this method with `bigList` it works as expected.

```scala
sumOfListTailRec(bigList, 0)
```

Let first discuss why this problem occurs, and then move on to defining tail
recursion.
"""
