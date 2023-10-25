import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg1189 {
	
	static int R, C, K, count;
	
	static char[][] alp;
	
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		alp = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				alp[i][j] = str.charAt(j);
			}
		}
		
		bt(R-1, 0, 1);
	
		System.out.println(count);
		
	}
	
	public static void bt(int y, int x, int leng) {
		visited[y][x] = true;
		
		if (y == 0 && x == C-1) {
			if (leng == K) {
				count++;
				return;
			}
		}
		
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		for (int i = 0; i < 4; i++) {
			int Y = y + dy[i];
			int X = x + dx[i];
			
			if(X < 0 || X >= C || Y < 0 || Y >= R || alp[Y][X] == 'T') continue;
			
			if (alp[Y][X] == '.' && !visited[Y][X]) {
				visited[Y][X] = true;
				bt(Y, X, leng+1);
				visited[Y][X] = false;
			}
			
		}
		
		
	}
}
