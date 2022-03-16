import PuzzleReaderWriter.{closing, getNumPuzzles, initRW, putSolution, readingPuzzle}


object PuzzleSolver extends App {
  def solve(puzzle: Puzzle): Puzzle = {


    // This prints the puzzle board.
    puzzle.printBoard()


    return new Puzzle(puzzle.sizeRow, puzzle.sizeCol, puzzle.solution, puzzle.puzzleBoard)
  }

  //  readingPuzzle(args(0))
  //  initRW(args(0), args(1))
}

// Unfinished solver, but the general structure of it would be as follows:

object solver extends App {
  // We will use backtracking, so here we create 2 variables that will count all the visited
  // and promising nodes. [Learned from IKT301]
  var visited_nodes = 0
  var promising_nodes = 0

  // Here we will need functions for all of the game's rules, restrictions and operations.
  // Some examples are:
  def placing_light(): Unit = {
  }

  def wall_stopping_light(): Unit = {
  }

  def checking_if_light_illuminating_another_light(): Unit = {
  }

  def checking_if_lights_adjacent_to_square_is_equal_to_square_number(): Unit = {

  }

  def checking_if_solved(): Unit = {

  }
  // etc.

  // We will also need a backtracking and/or brute forcing algorithm to try placing light bulbs in all squares.

  def backtracking(): Unit = {
    // increasing visited nodes for every step.
    visited_nodes += 1

    // Backtracking will be called recursively in backtracking.
    backtracking()

    // if ( next node is promising)
    promising_nodes += 1
  }

  def heuristic(): Unit = {
    // Here the method for how we go about inputting light bulbs, will be given.
    // By the use of a heuristic, we will be able to cut down the time, the backtracking/brute forcing algorithm will use
    //The heuristic would start with squares that are marked with the highest number first.
  }
}


