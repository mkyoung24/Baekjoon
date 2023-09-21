import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg1987 {
	
	static int R,C;
	
	static int max = 0;
	
	static int[][] ans;
	
	static boolean[] alpha;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());		//세로
		C = Integer.parseInt(st.nextToken());		//가로
		
		ans = new int[R][C];
		alpha = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				ans[i][j] = s.charAt(j) - 'A';
			}			
		}
				
		DFS(0, 0, 1);
		System.out.println(max);
		
	}
	
	public static void DFS(int y, int x, int len) {
			alpha[ans[y][x]] = true;
			max = Math.max(max, len);
			
			int[] dx = {-1, 0, 1, 0};
		    int[] dy = {0, 1, 0, -1};
		    
		    for (int i = 0; i < 4; i++) {
		    	int ny = y + dy[i];		    	
		    	int nx = x + dx[i];
		    	
		    	if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
		    	
		    	if(!alpha[ans[ny][nx]]) {
		    		DFS(ny, nx, len + 1);
		    		alpha[ans[ny][nx]] = false;		    		
		    	}
		    }			
	}
}
