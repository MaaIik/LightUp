import Array._

// Initially I was attempting to solve the puzzle by using Arrays, but with regards to Scala, it
// was more suitable to use Lists instead.

// Here I tried to create a grid using Arrays.
// This approach was abandoned.

object testingGrid {
  def main(args: Array[String]) {

    val grid = new Grid(5, 5)

    grid.show()
  }
}

class Grid(r: Int, c: Int) {
  val row: Int = r
  val col: Int = c
  var gridMap = ofDim[String](row, col)
  for (i <- 0 to row - 1) {
    for (j <- 0 to col - 1) {
      gridMap(i)(j) = " "
    }
  }

  def updatePosition(posX: Int, posY: Int): Unit = {
    gridMap(posX)(posY) = "X"
  }

  def show(): Unit = {
    for (i <- 0 to row - 1) {
      print("|")
      for (j <- 0 to col - 1) {
        print(" " + gridMap(i)(j) + " | ")
      }
      println()
    }
  }
}

// This is a different method I tried.

//class ArrayExample{
//  var arr = Array.ofDim[Int](4,4)          // Creating multidimensional array
////  arr(1)(0) = 15
//  // Assigning value
//  def show(){
//    for(i<- 1 to 4){                       // Going through elements by using loop (not good for functional programming)
//      for(j<- 1 to 4){
//        print(" "+arr(i)(j))
//      }
//      println()
//    }
////    println("Third Element = "+ arr(1)(1))        // Accessing elements by using index
//  }
//}
//
//object MainObject{
//  def main(args:Array[String]){
//    var a = new ArrayExample()
//    a.show()
//  }
//}
//var arrayName = Array.ofDim[Int](4, 4)


