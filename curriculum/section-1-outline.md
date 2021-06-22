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
  - Motivation: Methods allow generalization over expressions. We can represent
    a set of expressions with a method, with parameters representing the part of
    the expression that varies.
  - Method syntax
    - Scala 2
    - Scala 3
    - Terminology: parameters & arguments, declaration and application, free and bound names
  - Method semantics
    - Substitution model for methods
      - Substitute a method call with the value it evaluates to (big step)
      - Small step: replace method call with method body, substituting
        parameters with the expressions (or is it the values?!?) they are called
        with
      - Only substitute in value position. 
      ```scala
      def example(x: Int): Int = foo.x(x) // which x do we substitute?
      ```
      - Maybe mention capture-avoiding substitution?
  - Process
    - A method is a contract: give me these inputs and I will give you this output. Another mental model for methods.
    - This motivates a process for writing methods. What is the contract? What are specific instances of that contract?
  - Questions
    - What is the difference between a method with no parameters and a value? Do methods without parameters have any use? If so, when?
    - Call-by-value vs call-by-name
      - Call-by-name sometimes halts when call-by-value does not
    - Methods that call themselves
    - Mutually recursive methods

- Structural Recursion over the Natural Numbers
  - Introduction to pattern matching
  - First example of programming strategy: structure of data matches structure of code---structural recursion

- Fractals
  - Reinforces reasoning principles for (structural) recursion
  - Open-ended project to finish this section 


## Notes

Most of this material already exists in Creative Scala. The installation section of Creative Scala is out of date, however.
