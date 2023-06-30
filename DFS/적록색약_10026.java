import java.util.Scanner;

public class Alg10026 {
	
	static char graph[][];
	
	static boolean visited[][];
	
	static boolean visit[][];
	
	static int N;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		graph = new char[N][N];
		visited = new boolean[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String s = scan.next();
			for(int j=0; j<N; j++) {
				graph[i][j] = s.charAt(j);
			}
		}
		
		char c,d;
		
		int count = 0;
		
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j] == 'R' && !visited[i][j]) {
					c = 'R';
					count++;
					dfs(i,j,c);
				}
				if(graph[i][j] == 'G' && !visited[i][j]) {
					c = 'G';
					count++;
					dfs(i,j,c);
				}
				if(graph[i][j] == 'B' && !visited[i][j]) {
					c = 'B';
					count++;
					dfs(i,j,c);
				}
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j] == 'R' && !visit[i][j]) {
					c = 'R';
					d = 'G';
					cnt++;
					dfs2(i,j,c,d);
				}
				if(graph[i][j] == 'G' && !visit[i][j]) {
					c = 'G';
					d = 'R';
					cnt++;
					dfs2(i,j,c,d);
				}
				if(graph[i][j] == 'B' && !visit[i][j]) {
					c = 'B';
					d = 'B';
					cnt++;
					dfs2(i,j,c,d);
				}
			}
		}
		
		System.out.print(count + "\n" + cnt);
	}
	
	public static void dfs(int a, int b, char c) {
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
			if(graph[y][x] != c) continue;
			
			visited[y][x] = true;
			
			dfs(y,x,c);
		}
	}
	
	public static void dfs2(int a, int b, char c, char d) {
		visit[a][b] = true;
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for(int i=0; i<4; i++) {
			int x = b + dx[i];
			int y = a + dy[i];
			
			if(x < 0 || x >= N || y < 0 || y >= N) {
				continue;
			}
			
			if(visit[y][x]) continue;
			if(graph[y][x] != c && graph[y][x] != d) continue;
			
			visit[y][x] = true;
			
			dfs2(y,x,c,d);
		}
	}
}
