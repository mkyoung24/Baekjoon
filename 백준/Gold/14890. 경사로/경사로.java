import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,L;
	
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (length(i)) count++;
			if (width(i)) count++;
		}
		
		System.out.println(count);
	}
	
	public static boolean length(int n) {			//세로 탐색
		boolean[] ck = new boolean[N];
		
		for (int i = 0; i < N - 1; i++) {
			int dif = map[i][n] - map[i + 1][n];
			
			if (dif > 1 || dif < -1) return false;
			else if (dif == -1) {
				for (int j = 0; j < L; j++) {
					if (i - j < 0 || ck[i - j]) return false;
					
					if (map[i][n] != map[i - j][n]) return false;
					
					ck[i - j] = true;
				}
			} else if (dif == 1) {
				for (int j = 1; j <= L; j++) {
					if (i + j >= N || ck[i + j]) return false;
					
					if (map[i][n] - 1 != map[i + j][n]) return false;
					
					ck[i + j] = true;
				}
			}
		}
		return true;	
	}
	
	public static boolean width(int n) {			//가로 탐색
		boolean[] ck = new boolean[N];
		
		
		for (int i = 0; i < N -1; i++) {
			int dif = map[n][i] - map[n][i+1];
			
			if (dif > 1 || dif < -1) return false;
			else if (dif == -1) {
				for (int j = 0; j < L; j++) {
					if (i - j < 0 || ck[i - j]) return false;
					
					if (map[n][i] != map[n][i - j]) return false;
					
					ck[i - j] = true;
				}
			} else if (dif == 1) {
				for (int j = 1; j <= L; j++) {
					if (i + j >= N || ck[i + j]) return false;
					
					if (map[n][i] - 1 != map[n][i + j]) return false;
					
					ck[i + j] = true;
				}
			}
		}
		
		return true;
		
	}
}
