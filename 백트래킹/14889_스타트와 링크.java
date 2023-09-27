import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg14889 {
	
	static int n;
	
	static int[][] num;
	
	static boolean[] visited;		//스타트는 True, 링크는 False
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		StringTokenizer st; 
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine()); 
			for (int j = 1; j <= n; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bt(1, 0);
		
		System.out.println(min);
				
	}
	
	public static void bt(int depth, int count) {
		if(count == n / 2) {
			sum();
			return;
		}
		
		for (int i = depth; i <= n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				bt(i+1, count+1);
				visited[i] = false;
			}
		}
	}
	
	public static void sum() {
		int start = 0;
		int link = 0;
		for (int i = 1; i <= n - 1; i++) {
			for (int j = i + 1; j <= n; j++) {
				if(visited[i] == true && visited[j] == true) {
					start += num[i][j];
					start += num[j][i];
				}
				
				if(visited[i] == false && visited[j] == false) {
					link += num[i][j];
					link += num[j][i];
				}
			}
		}
		
		if(Math.abs(start-link) == 0) {
			System.out.println(start-link);
			System.exit(0);
		} else {
			min = Math.min(min, Math.abs(start-link));
		}
	}
}
