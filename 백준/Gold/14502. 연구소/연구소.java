import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	
	static int[][] num;
	
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		//세로
		M = Integer.parseInt(st.nextToken());		//가로

		num = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for ( int j = 0; j < M; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(max);
		
	}
	
	public static void dfs(int cnt) {
		if (cnt == 3) {
			bfs();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (num[i][j] == 0) {
					num[i][j] = 1;
					dfs(cnt+1);
					num[i][j] = 0;
				}
			}
		}
		
	}
	
	public static void bfs() {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			copy[i] = Arrays.copyOfRange(num[i], 0, M);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 2) {
					virus(copy, i, j);
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		max = Math.max(max, cnt);
	}
	
	public static void virus(int[][] copy, int y, int x) {
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		Queue<int[]> position = new LinkedList<>();
		
		position.add(new int[]{y,x});
		
		while(!position.isEmpty()) {
			int[] cur = position.poll();
			
			for (int i = 0; i < 4; i++) {
				int Y = cur[0] + dy[i];
				int X = cur[1] + dx[i];
				
				if (check(Y,X) && copy[Y][X] == 0) {
					copy[Y][X] = 2;
					position.add(new int[] {Y,X});
				}
			}
		}
		
	}
	
	public static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
}
