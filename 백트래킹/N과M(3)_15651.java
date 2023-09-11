import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg15651 {
	
	static int N,M;
	
	static int[] ans;
	
	static boolean[] visited;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int [M];
		visited = new boolean [N];
		
		DFS(0);
		System.out.println(sb);
	}
	
	public static void DFS(int start) {
		if(start == M) {
			for(int i=0; i<M; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
			for(int i=0; i<N; i++) {
				visited[start] = true;
				ans[start] = i+1;
				DFS(start+1);
				visited[start] = false;
			}
		
	}
}
