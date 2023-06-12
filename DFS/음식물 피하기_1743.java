import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Alg1743 {
	
	static int graph[][];
	
	static boolean visited[][];
	
	static int N, M, K;
	
	static int cnt = 0;
	
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][M+1];
		
		visited = new boolean[N+1][M+1];
		
		
		for(int i=0; i<K; i++) {
			StringTokenizer sr = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(sr.nextToken());
			int b = Integer.parseInt(sr.nextToken());
			
			graph[a][b] = 1;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(graph[i][j] == 1 && !visited[i][j]) {
					cnt = 1;
					visited[i][j] = true;
					//dfs(i, j);
					//bfs(i,j);
					dfs2(i,j);
					ans = Math.max(cnt, ans);
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static void dfs(int a, int b) {
				
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for(int i=0; i<4; i++) {
			int c = a + dx[i];
			int d = b + dy[i];
			
			if(c < 1 || c > N || d < 1 || d > M) {
				continue;
			}
			if(visited[c][d]) continue;
			if(graph[c][d] == 0) continue;
			
			visited[c][d] = true;
			cnt++;
			
			dfs(c,d);
			
		}
		
	}
	
	public static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {a,b});
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int i=0; i<4; i++) {
				int c = poll[0] + dx[i];
				int d = poll[1] + dy[i];
				
				if(c < 1 || c > N || d < 1 || d > M) {
					continue;
				}
				
				if(visited[c][d]) continue;
				if(graph[c][d] == 0) continue;
				
				q.offer(new int[] {c,d});
				visited[c][d] = true;
				cnt++;
			}
		}
	}
	
	public static void dfs2(int a, int b) {
		Stack<int[]> s = new Stack<>();
		
		s.push(new int[] {a,b});
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		while(!s.isEmpty()) {
			int[] pop = s.pop();
			
			for(int i=0; i<4; i++) {
				int c = pop[0] + dx[i];
				int d = pop[1] + dy[i];
				
				if(c < 1 || c > N || d < 1 || d > M) {
					continue;
				}
				
				if(visited[c][d]) continue;
				if(graph[c][d] == 0) continue;
				
				s.push(new int[] {c,d});
				visited[c][d] = true;
				cnt++;
			}
		}
	}
}
