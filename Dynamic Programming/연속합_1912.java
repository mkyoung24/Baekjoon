import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg1912 {
	static int n;
	
	static int[] num;
	
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = num[0];
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1]+num[i], num[i]);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			if(dp[i] > max) max = dp[i];
		}
		
		System.out.println(max);
		
	}
}
