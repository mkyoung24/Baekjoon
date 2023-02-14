import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Alg2748 {
	static long[] dp;
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new long[91];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		
		System.out.println(Fibo(n));
	}
	
	public static long Fibo(int a) {	
		if(a == 0) return dp[0];
		if(a == 1) return dp[1];
		
		if(dp[a] == -1) {
			dp[a] = Fibo(a-1) + Fibo(a-2);		
		}
		
		return dp[a];
	
		
	}

}
