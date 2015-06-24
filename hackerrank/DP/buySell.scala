/** Stock Maximize 
https://www.hackerrank.com/challenges/stockmax

3
3
5 3 2
3
1 2 100
4
1 3 1 2

**/
def solve(n: Int, arr: Array[Int]) = {
	val profit = Array.ofDim[Int](n+1, n)
	for (i <- 0 to n){
		// println(i)
		profit(i)(n-1) = arr(n-1) * i // setting last column
	}

	for {
		i <- n-2 to 0 by -1 //columns - days
		j <- i to 0 by -1 //rows # of stocks
	} {
		if(j-1 < 0){
			profit(j)(i) = math.max(profit(j)(i+1), profit(j+1)(i+1) - arr(i))
		} else if(j+1 > n -1){
			profit(j)(i) = math.max(profit(j)(i+1), profit(j-1)(i+1) + arr(i))	
		} else {
			// println(s"($j)($i) ${arr(i)} ${profit(j)(i+1)}, ${profit(j-1)(i+1)}, ${profit(j+1)(i+1)}")
			profit(j)(i) = math.max(profit(j)(i+1), math.max(profit(j-1)(i+1) + arr(i), profit(j+1)(i+1) - arr(i)))			
		}
	}
	profit(0)(0) = math.max(profit(0)(1), profit(1)(1) - arr(0))
	println(profit(0)(0))

	// for {
	// 	i <- n -1 to 0 by -1
	// 	j <- i to 0 by - 1
	// } println(s"($j)($i) = ${profit(j)(i)}")
}


val ln = readInt
for(_ <- 0 until ln){
	val n = readInt
	val line = readLine
	val arr: Array[Int] =line.split(" ").map(_.toInt)
	solve(n, arr)
}


object Solution extends App{
	// def solve(prices) = {

	// }


	val n = readInt
        for(_ <- 1 until n){
        	val _ = readInt
        	val line = readLine
        	println(line)
        }

    // def main(args: Array[String]) {
    //      Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution 


    // }
}