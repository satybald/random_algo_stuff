package algo.graph

/**
 * Created by satybald on 6/24/15.
 */

import scala.collection.mutable.Queue
import scala.collection.mutable.TreeSet
import scala.collection.mutable.SortedSet

class DepthFirstSearch(g: Graph, s: Int, e: Int) {
  def path():String = {
    val visited: SortedSet[Int] =  TreeSet[Int]()
    val adjV: Queue[Int] = Queue[Int]()
    adjV += s
    while(adjV.size >0){
      val cV = adjV.dequeue()
      if(!adjV.contains(cV)){
        adjV ++ g.adj(cV)
        visited += cV
      }
    }
    adjV.mkString("-> ")
  }
}
