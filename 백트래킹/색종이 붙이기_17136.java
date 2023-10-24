import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg17136 {
	
	static int[][] num = new int[10][10];
	
	static int paper[] = {0, 5, 5, 5, 5, 5};
	
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bt(0,0,0);
		
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
		
	}
	
	public static void bt(int x, int y, int cnt) {
		if (x >= 9 && y > 9) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if (ans <= cnt) {
			return;
		}
		
		if (y > 9) {
			bt(x+1, 0, cnt);
			return;
		}
		
		if (num[x][y] == 1) {
			for (int i = 5; i >= 1; i--) {
				if (paper[i] > 0 && isAttach(x, y, i)) {
					attach(x, y, i, 0);
					paper[i]--;
					bt(x, y + 1, cnt + 1);
					attach(x, y, i, 1);
					paper[i]++;
				}
			}
		} else {
			bt(x, y + 1, cnt);
		}
	}
	
	public static void attach(int x, int y, int size, int state) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				num[i][j] = state;
			}
		}
	}
	
	public static boolean isAttach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10) {
					return false;
				}
				
				if (num[i][j] != 1) {
					return false;
				}
			}
		}
		
		return true;
	}
}
