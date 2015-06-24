package algo.graph

import org.scalacheck._
import Prop.forAll
import Arbitrary.arbitrary
import Gen.choose
import java.io.File
/**
 * Created by satybald on 6/23/15.
 */
object GraphTest extends Properties("Graph"){

  def evenInt(n:Int) = for {
    v <- Gen.choose(0, n)
    w <- Gen.choose(0, n) if v != w
  } yield (v,w)

  val genGraphWithN = for {
    n <- choose(0, 100)
  } yield (n,new Graph(n))

//  property("graph degree") = forAll(genGraphWithN){case (n: Int, g:Graph) =>
//
//    forAll(evenInt(n)){ case (v,w)=>
//        g.addEdge(w, v)
//        Graph.allDegree(g) == 2
//    }
//  }

  property("load from file") = forAll(Gen.oneOf("src/test/resources/tinyG.txt", "src/test/resources/tinyG.txt")){ file:String=>
    val file2 = new File(".")
    println(file2.getAbsolutePath)
    val g = new Graph(file)
    println(g)
    g.size == 13
  }

}
