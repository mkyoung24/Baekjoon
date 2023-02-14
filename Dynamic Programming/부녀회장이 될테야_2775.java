import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg2775 {
	static int[][] dp = new int [15][15];
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<15; i++) {
			dp[i][0] = 1;
			dp[0][i] = i+1;
		}
		
		for(int k=1; k<15; k++) {
			for(int j=1; j<15; j++) {
				dp[k][j] = dp[k-1][j] + dp[k][j-1];
			}
		}
		
		
		for(int i=0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[k][n-1]).append("\n");			
		}
		
		System.out.println(sb);
	}
}
