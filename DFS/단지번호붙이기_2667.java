import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Alg2667 {
	
	static int graph[][];
	
	static boolean visited[][];
	
	static int part[];
	
	static int N;
	
	static int cnt;
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		int count = 0;
		
		graph = new int[N][N];
		
		visited = new boolean[N][N];
		
		part = new int[N*N];
		
		for(int i=0; i<N; i++) {
			String a = scan.next();
			for(int j=0; j<N; j++) {
				graph[i][j] = a.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j] == 1 && !visited[i][j]) {
					++count;
					cnt = 0;
					part[count] = dfs(i,j);

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
			int c = a + dx[i];
			int d = b + dy[i];
			
			if(c < 0 || c >= N || d < 0 || d >= N) {
				continue;
			}
			if(visited[c][d]) continue;
			if(graph[c][d] == 0) continue;
			
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
				int c = poll[0] + dx[i];
				int d = poll[1] + dy[i];
				
				if(c < 0 || c >= N || d < 0 || d >= N) {
					continue;
				}
				if(visited[c][d]) continue;
				if(graph[c][d] == 0) continue;
				
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
				int c = pop[0] + dx[i];
				int d = pop[1] + dy[i];
				
				if(c < 0 || c >= N || d < 0 || d >= N) {
					continue;
				}
				if(visited[c][d]) continue;
				if(graph[c][d] == 0) continue;
				
				visited[c][d] = true;
				cnt++;
				s.push(new int[] {c,d});
			}
		}
		return cnt;
		
	}
}
