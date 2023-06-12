import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg1012 {
	
	static boolean[][] visitied;
	
	static int[][] graph;
	
	static int M, N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<num; i++) {
			StringTokenizer sr = new StringTokenizer(br.readLine());
			M = Integer.parseInt(sr.nextToken());
			N = Integer.parseInt(sr.nextToken());
			K = Integer.parseInt(sr.nextToken());
			
			visitied = new boolean[M][N];
			graph = new int [M][N];
			
			for(int j=0; j<K; j++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				graph[a][b] = 1;
			}
			
			int cnt = 0;
			
			for(int k=0; k<M; k++) {
				for(int l=0; l<N; l++) {
					if(graph[k][l] == 1 && !visitied[k][l]) {
						//dfs(k, l);
						bfs(k,l);
						
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}

	}
	
	public static void dfs(int a, int b) {
		visitied[a][b] = true;
		
		int[] x = {0, 0, -1, +1};
		int[] y = {-1, +1, 0, 0};
		
		for(int i=0; i<4; i++) {
			int c = a + x[i];
			int d = b + y[i];
			
			if(c < 0 || c >= M || d < 0 || d >= N) {
				continue;
			}
			
			if(graph[c][d] == 1 && !visitied[c][d]) {
				dfs(c, d);
			}
		}
		
	}
	
	public static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {a,b});
		
		visitied[a][b] = true;
		
		int[] x = {0, 0, -1, +1};
		int[] y = {-1, +1, 0, 0};
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int i=0; i<4; i++) {
				int c = poll[0] + x[i];
				int d = poll[1] + y[i];
				
				if(c < 0 || c >= M || d < 0 || d >= N) {
					continue;
				}
				
				if(graph[c][d] == 1 && !visitied[c][d]) {
					q.offer(new int[] {c,d});
					visitied[c][d] = true;
				}
			}
		}
		
	}

}
