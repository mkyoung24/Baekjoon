import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M, ans;
	
	static int[][] room;
	
	static int dy[] = {-1, 0, 1, 0};
	
	static int dx[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 1;
		clean(y, x, dir);
		
		System.out.println(ans);

	}
	
	public static void clean(int y, int x, int dir) {
		room[y][x] = 2; 	
		
		for (int i = 0; i < 4; i++) {
			dir -= 1;
			if (dir == -1) dir = 3;
			
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			
			if (ny >= 0 && ny < N && nx >= 0 && nx < M && room[ny][nx] == 0) {
				ans++;
				clean(ny, nx, dir);
				return;
			}
		}
		
		int back = (dir + 2) % 4;
		int by = y + dy[back];
		int bx = x + dx[back];
		
		if (by >= 0 && by < N && bx >= 0 && bx < M && room[by][bx] != 1) {
			clean(by, bx, dir);
		}
	}
}

