import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Alg15655 {
	
	static int N,M;
	
	static int num[];
	
	static int ans[];
	
	static boolean visited[];
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		visited = new boolean[N];
		ans = new int [M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);		
		dfs(0,0);
		
		System.out.println(sb);
				
	}
	
	public static void dfs(int start, int end) {
		if (start == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = end; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[start] = num[i];
				end = i+1;
				dfs(start+1,end);
				visited[i] = false;
			}			
		}
	}
}
