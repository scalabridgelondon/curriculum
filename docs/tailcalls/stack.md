package scalabridge
package tailcalls

import mads.*

object Stack extends Section:
  def content[A](mads: Mads[A]): A = 
    import mads.syntax.*

    md"""
# The Stack

In the previous section we saw a recursive method that failed with a
`StackOverflowError` when working with large data. In this section we'll learn
about the stack and why this error occurs.

We were working with the method `sumOfList`, which is duplicated below.

```scala mdoc:silent
def sumOfList(list: List[Int]): Int =
  list match {
    case Nil => 0
    case hd :: tl => hd + sumOfList(tl)
  }
```

Let's look at what happens when we use substitution to evaluate this method on
the input `List(1, 2, 3, 4, 5)`. We start with the method call and its argument.

```scala
sumOfList(List(1, 2, 3, 4, 5))
```

We can now substitute the body of the method with `list` bound to `List(1, 2, 3, 4, 5)`

```scala
List(1, 2, 3, 4, 5) match {
    case Nil => 0
    case hd :: tl => hd + sumOfList(tl)
  }
```

Continuing with substitution (and skipping the pattern matching step) we get to the recursive step

```scala
1 + sumOfList(List(2, 3, 4, 5))
```

Expanding a few more times gets us to

```scala
1 + 2 + sumOfList(List(3, 4, 5))
```

We can complete the recursion to the base case to get to

```scala
1 + 2 + 3 + 4 + 5 + 0
```

Now on to the important bit. At each point in this substitution we have part of
computation waiting for a recursive call to complete. For example at

```scala
1 + 2 + sumOfList(List(3, 4, 5))
```

we're waiting for the recursion on `List(3, 4, 5)` to finish and, when it does,
we'll add `2` and `1` to the result. This "waiting" takes up space in the
computer's memory! The computer needs to remember to do these additions when the
recursion finishes, and it stores this information in an area of memory called
the stack. When we see a `StackOverflowError` this means that the computer has
run out of memory in the stack, as we could imagine occurring when we call
`sumOfList` on a very long list.
"""
