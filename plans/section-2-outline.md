# Section 2 Outline

Section 2 introduces core functional programming concepts: functions, algebraic data types, and structural recursion over algebraic data types. The approach is "do stuff" first, and then explain concepts.

We continue to use Doodle, but should look at adding another domain at the section progresses. I've suggested a Twitter bot below.


## Goals

Students can:

- declare and use functions and function types
- understand type signatures with generic types
- apply structural recursion over `List`
- maybe map and flatMap?
- translate descriptions of data into algebraic data types
- apply structural recursion over algebraic data types


## Content

- Functions
  - This is currently introduced in Creative Scala using parametric equations for curves. This is fun, but requires explaining some concepts (polar coordinates, parametric equations) that are unfamiliar to some students. An alternative would be to implement a library for common tilings (e.g. square, hexagon) and have them pass functions to methods in this library. The function would create the element to be rendered at each location of the tiling. We can also contextualize with reference to, e.g., fabric patterns and Islamic art.

- Maybe introduce animations here? Using reactors is more experience with functions.

- List
  - list as a container for data
  - using generic types / type variables
  - structural recursion over Lists
  - abstraction over structural recursion: map, flatMap
  
- Maybe introduce Random here? Same concepts as List but different context.
  
- Algebraic data types
  - structural recursion over algebraic data types
  - finite state machines as animations
  
- Twitter bot
  - Opened ended project to create a Twitter bot that posts pictures they have created to Twitter. We would have to supply a good portion of the framework. Practice using functions and data, and start the shift into the web domain.


## Notes

The majority of this material is in Creative Scala.
