import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg1063 {
	static int kingx;
	static int kingy;
	static int stonex;
	static int stoney;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String king = st.nextToken();
		kingx = king.charAt(0)-'A'+1;
		kingy = king.charAt(1)-'0';
		
		
		String stone = st.nextToken();
		stonex = stone.charAt(0)-'A'+1;
		stoney = stone.charAt(1)-'0';
		
		int n = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			switch(s) {
				case "R":
					move(kingx+1, kingy);
					break;
				case "L":
					move(kingx-1, kingy);
					break;
				case "B":
					move(kingx, kingy-1);
					break;
				case "T":
					move(kingx, kingy+1);
					break;
				case "RT":
					move(kingx+1, kingy+1);
					break;
				case "LT":
					move(kingx-1, kingy+1);
					break;
				case "RB":
					move(kingx+1, kingy-1);
					break;
				case "LB":
					move(kingx-1, kingy-1);
					break;
			}
			
		}
		
		System.out.print((char) ('A' + kingx - 1));
		System.out.print(kingy + "\n");
		System.out.print((char) ('A' + stonex - 1));
		System.out.print(stoney);
		
	}
	
	public static void move(int x, int y) {
		if (x < 1 || x > 8 || y < 1 || y > 8) {
			return;
		}
		
		int dx = x - kingx;
		int dy = y - kingy;
		
		if (stonex + dx < 1 || stonex + dx > 8 || stoney + dy < 1 || stoney + dy > 8) return;
		
		if (x == stonex && y == stoney) {
				
			stonex += dx;
			stoney += dy;
			kingx = x;
			kingy = y;
		}
	
	}
}
