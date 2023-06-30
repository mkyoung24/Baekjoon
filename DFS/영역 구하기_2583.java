import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Alg2583 {
	
	static boolean visited [][];
	
	static int graph[][];
	
	static int part[];
	
	static int M, N, K, cnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());	//세로	
		
		N = Integer.parseInt(st.nextToken());	//가로
		
		graph = new int[M][N];
		visited = new boolean[M][N];
		part = new int [M*N];
		
		K = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		for(int i=0; i<K; i++) {
			StringTokenizer sr = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(sr.nextToken());
			int b = Integer.parseInt(sr.nextToken());
			int c = Integer.parseInt(sr.nextToken());
			int d = Integer.parseInt(sr.nextToken());
			
			for(int j=b; j<d; j++) {
				for(int k=a; k<c; k++) {
					graph[j][k] = 1;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j] != 1 && !visited[i][j]) {
					++count;
					cnt = 0;
					//part[count] = dfs(i,j);
					//part[count] = bfs(i,j);
					part[count] = dfs2(i,j);
				}
			}
		}
		
		System.out.println(count);
		Arrays.sort(part);
		
		for(int i=0; i<part.length; i++) {
			if(part[i] != 0) {
				System.out.println(part[i]);
			}
		}
		
	}
	
	public static int dfs(int a, int b) {
		visited[a][b] = true;
		cnt++;
		
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for(int i=0; i<4; i++) {
			int c = a + dy[i];
			int d = b + dx[i];
			
			if(c < 0 || c >= M || d < 0 || d >= N) {
				continue;
			}
			
			if(visited[c][d]) continue;
			if(graph[c][d] == 1) continue;
			
			visited[c][d] = true;
			
			dfs(c,d);
			
		}
		return cnt;
	}
	
	public static int bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {a,b});
		
		visited[a][b] = true;
		cnt++;
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			for(int i=0; i<4; i++) {
				int c = poll[0] + dy[i];
				int d = poll[1] + dx[i];
				
				if(c < 0 || c >= M || d < 0 || d >= N) {
					continue;
				}
				if(visited[c][d]) continue;
				if(graph[c][d] == 1) continue;
				
				visited[c][d] = true;
				cnt++;
				q.offer(new int[] {c,d});
			}
		}
		return cnt;
	}
	
	public static int dfs2(int a, int b) {
		Stack<int []> s = new Stack<>();
		
		visited[a][b] = true;
		cnt++;
		
		s.push(new int[] {a,b});
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		while(!s.isEmpty()) {
			int[] pop = s.pop();
			for(int i=0; i<4; i++) {
				int c = pop[0] + dy[i];
				int d = pop[1] + dx[i];
				
				if(c < 0 || c >= M || d < 0 || d >= N) {
					continue;
				}
				if(visited[c][d]) continue;
				if(graph[c][d] == 1) continue;
				
				visited[c][d] = true;
				cnt++;
				s.push(new int[] {c,d});
			}
		}
		return cnt;
		
	}

}
