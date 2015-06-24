package algo.graph

import org.scalatest.{BeforeAndAfter, FunSuite}
/**
 * Created by satybald on 6/24/15.
 */

class DeapthSearchTest extends FunSuite with BeforeAndAfter {
   before{
     g = new Graph("src/test/resources/tinyG.txt")
   }
  var g: Graph = _

  test("1st test"){
    val dfs:DepthFirstSearch = new DepthFirstSearch(g, 0, 6)
    println(dfs.path())
    assert(dfs.path() == "0-> 5-> 6")
  }

}
