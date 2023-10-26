import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg1405 {
	
	static int N;
	
	static double result;
	
	static boolean[][] visited = new boolean[29][29];
	
	static double[] loc = new double[4];		//동,서,남,북
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		loc[0] = Integer.parseInt(st.nextToken()) * 0.01;
		loc[1] = Integer.parseInt(st.nextToken()) * 0.01;
		loc[2] = Integer.parseInt(st.nextToken()) * 0.01;
		loc[3] = Integer.parseInt(st.nextToken()) * 0.01;
		
		result = 0;
		bt(14, 14, 0, 1);
		
		System.out.println(result);
	}
	
	public static void bt(int y, int x, int cnt, double ans) {
		if (cnt == N) {
			result += ans;
			return;
		}
		
		visited[y][x] = true;
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		for (int i = 0; i < 4; i++) {
			int Y = y + dy[i];
			int X = x + dx[i];
			
			if (X >= 0 && X < 29 && Y >= 0 && Y < 29) {
				if (visited[Y][X] == false) {
					visited[Y][X] = true;
					bt(Y, X, cnt + 1, ans * loc[i]);
					visited[Y][X] = false;
				}
			}
		}
	}
}
