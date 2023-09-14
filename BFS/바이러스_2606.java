import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg2606 {
	
	static int n,m,a,b,cnt;
	
	static int[][] graph;
	
	static boolean[] visited;
	
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for (int i = 1; i <= m; i++) {
			 st = new StringTokenizer(br.readLine());
			 a = Integer.parseInt(st.nextToken());
			 b = Integer.parseInt(st.nextToken());
			 graph[a][b] = graph[b][a] =  1;
		}
		
		cnt = 0;
		//bfs(1);
		dfs(1);
		System.out.println(cnt);
		
	}
	
	public static void bfs(int start) {
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			start = q.poll();
			
			for (int i = 1; i <= n; i++) {
				if(graph[start][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					++cnt;
				}
			}
		}
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		
		for (int i = 1; i <= n; i++) {
			if(graph[start][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i);				
			}
		}
		
	}
}
