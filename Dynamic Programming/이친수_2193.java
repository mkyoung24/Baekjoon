import java.io.*;

public class Alg2193 {
	static long[] dp  = new long[91];
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 1;
		System.out.println(Pinary(N));
	}
	
	static long Pinary(int n) {
		if(n == 1) return dp[1];
		if(n == 2) return dp[2];
		
		if(dp[n] > 0) {
			return dp[n];
		} else if(n >= 3){
			return dp[n] = Pinary(n-1) + Pinary(n-2);
		}
		
		return dp[n];
		
	}

}
