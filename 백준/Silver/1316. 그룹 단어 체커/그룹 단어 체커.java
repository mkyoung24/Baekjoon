import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			solve(br.readLine());
		}
		
		System.out.println(count);

	}
	
	public static void solve(String s) {
		int[] num = new int[26];
		num[s.charAt(0) - 'a'] = 1;
		char c = s.charAt(0);
		
		
		for (int i = 1; i < s.length(); i++) {
			if (c == s.charAt(i)) {
				continue;
			}
			
			
			if (num[s.charAt(i)-'a'] == 1) {
				return;
			} else {
				num[s.charAt(i)-'a'] = 1;
				c = s.charAt(i);
			}
			
		}
		
		++count;
	}
}
