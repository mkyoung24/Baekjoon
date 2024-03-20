import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long A, B;
	
	static long count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		solve(0);
		
		System.out.println(count);
	}
	
	public static void solve(long num) {
		if (num > B) return;
		
		if (num >= A && num <= B) {
			count++;
		}
		
		solve(num * 10 + 4);
		solve(num * 10 + 7);
	}
}
