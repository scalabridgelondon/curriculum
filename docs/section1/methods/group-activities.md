package section1.methods

import mads.*

trait GroupActivities[A](mads: Mads[A]):
  import mads.syntax.*
  
  val content = md"""
# Methods: Group Activities


## 1. Investigating Methods

Read the code for the method `mystery` below. Discuss in your group what you think the method does, *without* running the code. 

```scala
def mystery(color: Color): Image = {
  val c1 = color
  val c2 = c1.spin(15.degrees)
  val c3 = c2.spin(15.degrees)

  Image.regularPolygon(3, 200).strokeColor(c1)
    .beside(Image.regularPolygon(5, 200).strokeColor(c2))
    .beside(Image.regularPolygon(7, 200).strokeColor(c3))
    .strokeWidth(7.0)
}
```

Once you have decided on your answer, verify it by running the code. Here is an example of calling the method and drawing the result.

```scala
mystery(Color.crimson).draw()
```


## 2. Finding the Guilty Parties

Returning to the `mystery` method, which part of the method is responsible for:

- creating the colours for the shapes;
- creating the shapes and arranging them.

What value(s) does the value `c2` depend on?
What value(s) does the value `c3` depend on?
"""
