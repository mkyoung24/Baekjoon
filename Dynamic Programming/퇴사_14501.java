import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg14501 {
	static int[] T,P,dp;
	
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		T = new int[N+1];		//상담걸리는일
		P = new int[N+1];		//상담후받는금액
		dp = new int[N+2];
		
		StringTokenizer st;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N; i > 0; i--) {
			if ((i + T[i]) > N + 1) {
				dp[i] = dp[i+1];	
			} else {
				dp[i] = Math.max(dp[i+1], P[i] + dp[i+T[i]]);
			}
		}
		
		System.out.println(dp[1]);
		
	}
}
