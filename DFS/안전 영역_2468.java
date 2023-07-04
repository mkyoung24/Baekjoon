import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Alg2468 {
	
	static int graph[][];
	
	static boolean visited[][];
	
	static int N;
	
	static int cnt;
	
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
				
		graph = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				graph[i][j] = scan.nextInt();
			}
		}
		
		int a = max(N,graph);
		
		for(int k=0; k<=a; k++) {
			visited = new boolean[N][N];
			cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(graph[i][j] > k && !visited[i][j]) {
						cnt++;
						dfs(i,j,k);
						//dfs2(i,j,k);
						//bfs(i,j,k);
					}
				}
			}
			ans = Math.max(cnt, ans);
		}
		
		System.out.println(ans);
		
	}
	
	public static int max(int N, int graph[][]) {
		int max = graph[0][0];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(max < graph[i][j]) {
					max = graph[i][j];
				}
			}
		}
		
		return max;
	}
	
	public static void dfs(int a, int b, int c) {
		visited[a][b] = true;
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for(int i=0; i<4; i++) {
			int x = b + dx[i];
			int y = a + dy[i];
			
			if(x < 0 || x >= N || y < 0 || y >= N) {
				continue;
			}
			
			if(visited[y][x]) continue;
			if(graph[y][x] <= c) continue;
	
			dfs(y,x,c);
		}
	}
	
	public static void dfs2(int a, int b, int c) {
		Stack<int []> s = new Stack<>();
		
		visited[a][b] = true;
		
		s.push(new int[] {a,b});
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		while(!s.isEmpty()) {
			int[] pop = s.pop();
			for(int i=0; i<4; i++) {
				int y = pop[0] + dy[i];
				int x = pop[1] + dx[i];
				
				if(x < 0 || x >= N || y < 0 || y >= N) {
					continue;
				}
				
				if(visited[y][x]) continue;
				if(graph[y][x] <= c) continue;
				
				visited[y][x] = true;
				s.push(new int[] {y,x});
			}
		}
	}
	
	public static void bfs(int a, int b, int c) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {a,b});
		
		visited[a][b] = true;
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			for(int i=0; i<4; i++) {
				int y = poll[0] + dy[i];
				int x = poll[1] + dx[i];
				
				if(x < 0 || x >= N || y < 0 || y >= N) {
					continue;
				}
				
				if(visited[y][x]) continue;
				if(graph[y][x] <= c) continue;
				
				visited[y][x] = true;
				q.offer(new int[] {y,x});
			}
		}
		
	}
}
