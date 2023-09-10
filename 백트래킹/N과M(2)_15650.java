import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg15650 {
	static int N,M;
	
	static int[] ans;
	
	static int[] num;
	
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[N+1];
		num = new int[N+1];
		visited = new boolean[N];
		
		for(int i=1; i<=N; i++) {
			num[i] = i;
		}
		
		DFS(0,0);
		
	}
	
	public static void DFS(int start, int num) {
		if (start == M) {
			for(int i=0; i<M; i++) {
				 System.out.print(ans[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i=num; i<N; i++) {
			if (!visited[i]) {
				 visited[i] = true;
				 ans[start] = i+1;
				 DFS(start+1, i+1);
				 visited[i] = false;
			}
		}		
	}
}
