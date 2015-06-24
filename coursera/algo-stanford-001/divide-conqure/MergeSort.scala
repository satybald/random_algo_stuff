// object MergeSort extends App{
	def merge(st:Int, end: Int, in:Array[Int]) ={
		if(st > end || end < 0) in
		else{
			mid = st + (end - st)/2
			val arrayLeft = merge(st, mid, in)
			val arrayRight = merge(mid, end, in)
			val sortedArray = sort(arrayLeft, arrayRight)
			sortedArray
		}
	}

	def sort(ar1: Array[Int], ar2: Array[Int]):Array[Int] = {
		val n = ar1.length + ar2.length
		var i,j = 0
		var out= Array.ofDim[Int](n)
		for(x <- 0 to n-1){
			if(i==ar1.length){
				out(x) = ar2(j)
				j+=1
			}else if(j == ar2.length){
				out(x) = ar1(i)
				i+=1
			}
			else if(ar1(i) <= ar2(j)){
				out(x) = ar1(i)
				i+=1
			}else if(ar1(i)> ar2(j)){
				out(x) = ar2(j)
				j+=1
			}
		}
		out
	}

	val in = Array(2,5,1,3,4)
	// assert(sort(Array(1,3,4), Array(5,6)).deep == Array(1,3,4,5,6).deep)
	// assert(sort(Array(5,6),Array(1,3,4)).deep == Array(1,3,4,5,6).deep)
	// assert(sort(Array(1,3,5),Array(4,6)).deep == Array(1,3,4,5,6).deep)
	// println(sort(Array(1,3,5),Array(4,6)).mkString(" "))

// }