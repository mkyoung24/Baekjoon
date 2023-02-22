import java.util.*;

public class Alg11727 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[] dp = new long[1001];
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i=3; i<=n; i++) {
			dp[i] = (2 * dp[i-2] + dp[i-1]) % 10007;
		}
		
		System.out.println(dp[n]);
		
	}
}
