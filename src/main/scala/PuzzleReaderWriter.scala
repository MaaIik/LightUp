import globals.PuzzleGrid

import scala.io.Source
import java.io.FileWriter


object PuzzleReaderWriter {


  def readingPuzzle(infile: String): Puzzle = {
    val lines = Source.fromFile(infile).getLines().toList
    val puzzleDimensions: Array[String] = lines.filter(_ startsWith ("size")).head.split(" ").last.split("x") // Get the sizes
    val puzzleBoard: PuzzleGrid = lines.slice(2, puzzleDimensions.last.toInt + 2).map(_.toList)

    return new Puzzle(
      row = puzzleDimensions(0).toInt,
      col = puzzleDimensions.last.toInt,
      sol = None,
      _puzzleBoard = puzzleBoard
    )

  }

  def writingPuzzle(outfile: String, puzzle: Puzzle): Unit = {
    val fw = new FileWriter(outfile, false)
    fw.write("puzzle\n")
    fw.write("Size " + puzzle.sizeRow + "X" + puzzle.sizeCol)
    fw.write(puzzle.solution.fold("No solution found")(board =>
      board.map(row => row.mkString + "\n").mkString))
    fw.close // Close the file
  }

  var unsolvedFile: String = "";
  var solvedFile: String = "";
  var lines: List[String] = Nil;
  var fw: FileWriter = null;


  def initRW(infile: String, outfile: String) = {
    unsolvedFile = infile
    solvedFile = outfile
    lines = Source.fromFile(unsolvedFile).getLines().toList

    fw = new FileWriter(solvedFile, false)
  }

  // Read the amount of puzzles in a file
  def getNumPuzzles(): Int = {
    val countPuzzles = lines(0).split(" ").last.toInt
    // writing number of puzzles into solution
    fw.write("puzzles " + countPuzzles.toString + "\n")
    return countPuzzles
  }

  def putSolution(puzzle: Puzzle) = {
    fw.write("size " + puzzle.sizeRow + "x" + puzzle.sizeCol + "\n")
    fw.write(puzzle.solution + "\n")
  }


  def getPuzzleList(): Unit = {
    val (_, puzzleList) = lines.splitAt(2)
    for (i <- puzzleList) {
      val tempList = i.toList
      println(tempList)
    }
  }

  def closing() = {
    fw.close()
  }

}
