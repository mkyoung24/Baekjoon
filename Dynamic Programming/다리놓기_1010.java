import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg1010 {
	private static final int[][] dp = new int[31][31];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());		//N <= M
			
			System.out.println(combi(M, N));
		}
	}
	
	public static int combi(int n, int r) {
		if(dp[n][r] > 0) {
			return dp[n][r];
		} else if(n == r || r == 0) {
			return dp[n][r] = 1;
		} else {
			return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
		}
			
	}

}
