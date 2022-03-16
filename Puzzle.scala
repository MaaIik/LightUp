import PuzzleReaderWriter.lines
import globals.PuzzleGrid

import scala.collection.mutable.ListBuffer

// This project is unfinished, and includes many different methods and approaches I used along the way.
// You will find code snippets where I'm working on specific topics necessary to solve the greater puzzle

// Architecture consists of a Class Puzzle, which is the entire board itself,
// and a class PuzzleSquare, which is a single square in the puzzle.
// A square is given an x and y position and a value, so that it can function as a grid where I can insert values into it.

class Puzzle(row:Int,
             col:Int,
             sol:Option[PuzzleGrid],
             _puzzleBoard:PuzzleGrid) {
  val sizeRow: Int = row;
  val sizeCol: Int = col;
  val solution: Option[PuzzleGrid] = sol;
  val puzzleBoard: PuzzleGrid = _puzzleBoard

  // xPos and yPos are the coordinates of the individual squares.
  // possibleValues are the list of values each square can have
  class PuzzleSquare(xPos: Int,
                     yPos: Int,
                     possibleValues: List[Any] = List(0, 1, 2, 3, 4, 'X', '_', '*'),
                     solved: Boolean = false) {

    val values: List[Any] = possibleValues;
    val x: Int = xPos;
    val y: Int = yPos;
    val isSolved: Boolean = solved;

    override def toString(): String = {
      "x:" + x + " y:" + y + " value:" + values.mkString(",");
    }

    // Setting a square's value
    def setValue(solution: Any): PuzzleSquare = {
      return new PuzzleSquare(this.x, this.y, List(solution), true);
    }

    def removeValue(wrongSolution: Int): PuzzleSquare = {
      val newlist = values.filter(_ != wrongSolution);
      if (newlist.length == 1) {
        return new PuzzleSquare(this.x, this.y, newlist, solved = true); //found our number!
      }
      return new PuzzleSquare(this.x, this.y, newlist);
    }
  }

  override def toString: String = {
    s"${sizeRow}x${sizeCol} -->\n${solution}" +
      s"${printBoard()}"
  }

  def printBoard(): Unit = {
    puzzleBoard.foreach(s => {
      s.foreach(x => print(x + " "))
      println("")
    })
  }

}

//  __________________________________________________________________________________
// Here I'm creating a function to create a grid/2D list out of List(s).
// The next step is to read the unsolved puzzle text file, and create a grid from it
// And then apply the solution-finding algorithm, on that grid.

// (Initially, I was working on creating a grid through the use of Arrays, but I abandoned that approach.
// because List transformations are more suited to this task, in regards to Scala.)

object ListGrid{

  def main(args: Array[String]): Unit = {

    // Doing it manually to test if it works
    // This is puzzle "0_4x7_20_0_4x7:a2gBd1e2aBBc1.txt"

    // Note: I'm not attempting to solve it yet. Just making sure that my mapping to a 2D Grid/List works.
    val testPuzzle: List[Char] = List(
      '_', '2', '_', '_',
      '_', '_', '_', '_',
      '_', 'X', '_', '_',
      '_', '8', '_', '_',
      '_', '_', '_', '_',
      '2', '_', '_', 'X',
      '_', '_', '_', '1'
    )

    // Creating a grid manually
    val line1: ListBuffer[Any] = ListBuffer(0, testPuzzle(0), testPuzzle(1), testPuzzle(2), testPuzzle(3))
    val line2: ListBuffer[Any] = ListBuffer(0, testPuzzle(4), testPuzzle(5), testPuzzle(6), testPuzzle(7))
    val line3: ListBuffer[Any] = ListBuffer(0, testPuzzle(8), testPuzzle(9), testPuzzle(10), testPuzzle(11))
    val line4: ListBuffer[Any] = ListBuffer(0, testPuzzle(12), testPuzzle(13), testPuzzle(14), testPuzzle(15))
    val line5: ListBuffer[Any] = ListBuffer(0, testPuzzle(16), testPuzzle(17), testPuzzle(18), testPuzzle(19))
    val line6: ListBuffer[Any] = ListBuffer(0, testPuzzle(20), testPuzzle(21), testPuzzle(22), testPuzzle(23))
    val line7: ListBuffer[Any] = ListBuffer(0, testPuzzle(24), testPuzzle(25), testPuzzle(26), testPuzzle(27))

    val twoDimenstionalList: ListBuffer[ListBuffer[Any]] = ListBuffer(null, line1, line2, line3, line4, line5, line6, line7)

    // Printing example-Board, to test if the creation of the grid is correct.
    // Next step is to read the unsolved puzzle text file, and create a grid from it
    println("Puzzle: ")
    printList(twoDimenstionalList)

    // Updating a index through user input of x,y coordinates.
    println("Testing insertion through Indexes/Coordinates:")
    while (true) {
      println("Press 1: To insert Light bulb")
      val a = scala.io.StdIn.readInt()

      if (a == 1) {
        modifyIndexes(twoDimenstionalList)
        printList(twoDimenstionalList)
        println("Insertion Successful")
      }
    }
  }

  def printList(myList: ListBuffer[ListBuffer[Any]]): Unit = {
    for (i <- 1 to 7) {
      for (j <- 1 to 4) {
        print(myList(i)(j) + " ")
      }
      println()
    }
  }


  def modifyIndexes(myList: ListBuffer[ListBuffer[Any]]): Unit = {
    println("Enter the x coordinate of the row");
    val j = scala.io.StdIn.readInt()
    println("Enter the y coordinate of the column")
    val i = scala.io.StdIn.readInt()
    val value = '*'
    myList(i)(j) = value
  }

}


// Former approach

//  def createBoard() ={
//    for(xvalue<-List.range(1,sizeRow+1)){
//      for(yvalue<-List.range(1,sizeCol+1)){
//        var s = new Square(xPos,yPos)
//        allSquares = allSquares :+ s
//      }
//    }
//    }
//  // Doesn't work outside of function scope
//  createBoard()
