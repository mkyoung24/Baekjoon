import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [][] num = new int[n+1][n+1];
		int [][] dp = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + num[i][j];
			}
		}
		
		int ans = Integer.MIN_VALUE;
		
		for (int i = 1; i <= n; i++) {
			if (ans < dp[n][i]) ans = dp[n][i];
		}
		
		System.out.println(ans);
		
	}
}
