object Solution {
    def maxSubArr(n: Int, ar: Array[Int]): Int = {
        ar(0) = Math.max(ar(0), 0)
        var best_idx = 0
        var best_val = ar(0)
        for(i <- 1 to n -1){
           ar(i) = Math.max(ar(i -1)+ar(i), ar(i))
           if(ar(i) > best_val){
               best_idx = i
               best_val = ar(i)
           }
        }
        //println(ar.foreach(println(_)))
        ar(best_idx)
    }
    def maxSubArr(ar: Array[Int]): Int = {
        (ar.filter(_ > 0).foldLeft(0)(_+_))
    }

    def main(args: Array[String]) = {
        /* 
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
         */
        val ln = readLine().toInt
        for (i <- 1 to ln){
            val n = readInt()
            val st = readLine()
            val ar = st.split(" ").map(_.toInt)
            val x1 = maxSubArr(ar)
            val x2 = maxSubArr(n, ar)
            println(x2+" "+x1)
        }
        
    }
}