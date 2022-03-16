package object globals {

  // Here we define Type aliases [Lecture 5]
  type PuzzleRow = List[Char]
  type PuzzleGrid = List[PuzzleRow]

  // These are global variables only evaluated when needed, because they are of type lazy val
  // They are not utilized as of now, but included because they will come in handy later
  lazy val zero = '0'
  lazy val one = '1'
  lazy val two = '2'
  lazy val three = '3'
  lazy val four = '4'
  lazy val empty = '_' // underscore
  lazy val light = '*' // light bulb
  lazy val wall = 'X'

}