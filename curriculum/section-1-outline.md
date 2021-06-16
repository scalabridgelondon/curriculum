# Section 1 Outline

Section 1 introduces our students to programming in Scala. 

This section uses Doodle. Most of the examples will be images, and possibly animation. Doodle makes interesting output that is accessible to students. See the research on "media computation" for more justification.


## Goals

Students:

- have a working development environment
- can use their development environment to write and run Scala programs
- can read and write basic Scala syntax
- can use the substitution model of evaluation to reason about pure code
- can write programs that use structural recursion over the natural numbers
- can reason effectively about structural recursion


## Content

- Installation
  - OpenJDK
  - sbt
  - Development environment: we recommend Visual Studio Code + Metals, unless the student has prior experience or has mentors that use a different tool
  - Template project

- Expressions, Types, and Values
  - Learn the basic model:
    - Expressions evaluate to values.
    - Expressions have types, which represent a set of values.
  - Write simple expressions
    - Do some basic boring things. (Literals! Arithmetic expressions!)
    - Make some basic images with Doodle
  - Look at worksheet support for this--Scala 3 makes the difference between a worksheet and "real" code much smaller than in Scala 2 (namely more things can be defined at the top-level)

- Names and Scopes
  - Use names to refer to values
  - Introduce lexical scopes
  - Show names allow abstraction over expressions
  - Use names to build more complex pictures

- The Substitution Model of Evaluation
  - Describe substitution
  - Show how expressions can be evaluated by substitution
  - Define side effects in terms of substitution
  - Show how side effects can be used to investigate order of evaluation

- Methods
  - Defining methods
  - Substitution model for methods
  - Methods abstract over expressions
  - At this point we could ask some questions about substitution that illustrate the difference between eager and lazy evaluation, and also introduce recursion.

- Structural Recursion over the Natural Numbers
  - Introduction to pattern matching
  - First example of programming strategy: structure of data matches structure of code---structural recursion

- Fractals
  - Reinforces reasoning principles for (structural) recursion
  - Open-ended project to finish this section 


## Notes

Most of this material already exists in Creative Scala. The installation section of Creative Scala is out of date, however.
