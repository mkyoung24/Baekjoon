import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg1018 {
	
	static boolean[][] arr;
	
	static int n,m;
	
	static int min = 64;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				if(str.charAt(j) == 'W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}
		
		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				check(i, j);
			}
		}
		
		System.out.println(min);
	}
	
	public static void check(int y, int x) {
		int count = 0;
		
		boolean first = arr[y][x];
		
		for (int i = y; i < y + 8; i++) {
			for (int j = x; j < x + 8; j++) {
				if (arr[i][j] != first) {
					count++;
				}
				
				first = (!first);
			}
			
			first = (!first);
		}
		
		count = Math.min(count, 64 - count);
		
		min = Math.min(min, count);
		
	}
}
