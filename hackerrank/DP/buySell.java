import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Solution {
	
	int totalDays;
	int[] price;
		
	
	int totalStock;
	
	
	public Solution(int totalDays)
	{
		super();
		
		this.totalDays = totalDays;
		this.price = new int[totalDays];
		
		totalStock = 0;
	}
	
	
	
	public void addShare(int index, int val)
	{
		price[index] = val;
		totalStock += val;
	}
	
	public long calc()
	{
				
		//int result = rec(0, 0);
		long result = DP();
		return result;
	}
	
	public long DP()
	{
		long myStock = 0;//BigInteger.valueOf(0);
		
		//BigInteger myCash = BigInteger.valu//
		long myCash = 0;
		
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
	
		
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int t = Integer.parseInt(s); // testcases
		
		StringTokenizer st;
		
		for (int i = 0; i < t; i++)
		{
			
			
			int digits = Integer.parseInt(br.readLine());
			
			Solution sol = new Solution(digits);
			
			s = br.readLine();
			
			st = new StringTokenizer(s);
			
			for (int j = 0; j < digits; j++)
			{
				int share = Integer.parseInt(st.nextToken());
				sol.addShare(j, share);
				
			}
			System.out.println (sol.calc());
		}
	}

}
