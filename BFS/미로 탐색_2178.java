import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Alg2178 {
	
	static int [][] graph;
	
	static boolean [][] visited;
	
	static int N,M;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		
		graph = new int [N+1][M+1];
		visited = new boolean [N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String a = scan.next();
			for(int j=1; j<=M; j++) {
				graph[i][j] = a.charAt(j-1)-'0';
			}
		}		
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(graph[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(graph[N][M]);
		
	}
	
	public static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {a,b});
		
		visited[a][b] = true;
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int c = poll[0];
			int d = poll[1];
			
			for(int i=0; i<4; i++) {
				int y = poll[0] + dy[i];
				int x = poll[1] + dx[i];
				
				if(x < 1 || x > M || y < 1 || y > N) continue;
				
				if(visited[y][x]) continue;
				if(graph[y][x] == 0) continue;
				
				q.offer(new int[] {y,x});
				graph[y][x] = graph[c][d] + 1;
				visited[y][x] = true;
			}
		}
	}
}
