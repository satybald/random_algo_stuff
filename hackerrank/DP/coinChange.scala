/**
https://www.hackerrank.com/challenges/coin-change
4 3
1 2 3 

10 4
2 5 3 6
*/
object Solution extends App{

    def solve(n: Int, coins: Array[Int]) ={
        val m = coins.length
        var table = Array.ofDim[Int](n+1,m+1)
        for(i <- 0 to n){
            for(j <-0 to m){
                if(i == 0)
                    table(i)(j) = 1
                else if(j == 0)
                    table(i)(j) = 0
                else if(i < coins(j-1))
                    table(i)(j) = table(i)(j-1)
                else
                    table(i)(j) = table(i)(j-1) + table(i-coins(j))(j)   

            }
        }
        println(table(n)(m))
    }
    
    // val ln = readLine().split(" ").map(_.toInt)(0)
    // val coins = readLine().split(" ").map(_.toInt)
    solve(4, Array(1,2,3))

}