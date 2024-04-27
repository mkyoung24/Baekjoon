import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	
	static int[][] num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N][M];
		
		for (int i = 0; i < N; i++) {
	       String str = br.readLine();
	       for(int j = 0; j < M; j++) {
	          num[i][j] = str.charAt(j) - '0';
	       }
	    }
		
		int ans = 1;
		int area = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (N > M) {
					for (int k = 0; k < M; k++) {
						if (ck(i, j, k)) {
							area = (k+1) * (k+1);
							ans = Math.max(area, ans);
						}
					}
				} else {
					for (int k = 0; k < N; k++) {
						if (ck(i, j, k)) {
							area = (k+1) * (k+1);
							ans = Math.max(area, ans);
						}
					}
				}
			}
		}
		
		System.out.println(ans);

	}
	
	public static boolean ck(int y, int x, int len) {
		if (y + len >= N || x + len >= M) return false;
		
		if (num[y][x] == num[y][x+len] && num[y][x] == num[y+len][x] && num[y][x] == num[y+len][x+len]) return true;
		
		return false;
	}
}
