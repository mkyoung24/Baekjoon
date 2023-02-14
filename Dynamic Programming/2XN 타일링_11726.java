import java.io.*;

public class Alg11726 {
	static long[] dp = new long[1001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp[1] = 1 % 10007;
		dp[2] = 2 % 10007;
		System.out.println(Rec(n));
	}
	
	static long Rec(int n) {
		if(n == 1) return dp[1];
		if(n == 2) return dp[2];
		
		if(dp[n] > 0) {
			return dp[n];
		} else {
			return dp[n] = (Rec(n-1) + Rec(n-2)) % 10007;
		}
	}

}
