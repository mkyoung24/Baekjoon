import java.io.*;

public class Alg1904 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[1000001];
			for(int i=0; i<dp.length; i++) {
				dp[i] = -1;
			}
			dp[1] = 1;
			dp[2] = 2;
			
			for(int i=3; i<=N; i++) {
				dp[i] = (dp[i-1] + dp[i-2]) % 15746;
			}
			
			System.out.println(dp[N]);
	}

}

