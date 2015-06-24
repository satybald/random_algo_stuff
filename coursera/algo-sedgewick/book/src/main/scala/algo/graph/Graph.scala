package algo.graph

/**
 * Created by satybald on 6/23/15.
 */
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

class Graph() {

  private var vertex: Array[ListBuffer[Int]] = _
  private var E: Int = 0
  private var V: Int = 0

  def apply(V:Int) = {
    this.V = V
    vertex = Array.fill(V)(ListBuffer[Int]())
  }

  def this(V: Int) = {
    this()
    apply(V)
  }

  def this(file:String) = {
    this()
    val in = io.Source.fromFile(file).getLines()
    val n: Int = in.next().toInt
    val e: Int = in.next().toInt
    apply(n)
    for (x <- in){
      val ar = x.split(" ").map(_.toInt)
      addEdge(ar(0), ar(1))
    }
  }

  def adj(v: Int):Seq[Int] = vertex(v)

  def addEdge(v: Int, w: Int):Unit = {
    vertex(v)+=w
    vertex(w)+=v
    E +=1
  }

  def isEmpty:Boolean = vertex.isEmpty

  def size:Int = vertex.size

  override def toString():String = {
    var str = s"Vertexies: ${V}, Edges: $E \n"
    for((v,i) <- vertex.view.zipWithIndex){
      str += s"n ${i}: " +v.mkString(" ") + "\n"
    }
    str
  }
}

object Graph{

  def degree(g:Graph, v:Int) ={
    g.adj(v).size
  }

  def allDegree(g: Graph):Int = {
    var deg = 0
    for(i <- 0 until g.size){
      deg += g.adj(i).size
    }
    deg
  }

}
