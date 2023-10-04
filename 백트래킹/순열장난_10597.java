import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Alg10597 {	
	
	static String str;
	
	static int N;
	
	static boolean[] visited = new boolean[51];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		N = str.length();
		bt(0, 0, "");
	}
	
	public static void bt(int start, int end, String ans) {
		if (start == N) {
			for (int i = 1; i <= end; i++) {
				if (!visited[i]) return;
			}
			
			System.out.println(ans);
			System.exit(0);
		}
		
		String s = str.substring(start, start+1);
		int num = Integer.parseInt(s);
		if (!visited[num]) {
			visited[num] = true;
			bt(start+1, (num > end) ? num : end, ans + " " + s);
			visited[num] = false;
		}
		
		if (start < N -1) {
			s = str.substring(start, start + 2);
			num = Integer.parseInt(s);
			if(num < 51 && !visited[num]) {
				visited[num] = true;
				bt(start + 2, (num > end) ? num : end, ans + " " + s);
				visited[num] = false;
			}
		}
	}
}
