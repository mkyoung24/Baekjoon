import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[3];
		int cnt = 0;
		
		if (N >= 100) {
			cnt = 99;
			for (int i = 100; i <= N; i++) {
				if (i == 1000) break;
				
				int n = i;
				int j = 0;
				while (n > 0) {
					num[j] = n % 10;
					n /= 10;
					j++;
				}
				
				if ((num[0] - num[1]) == (num[1] - num[2])) cnt++;
			}
		} else {
			cnt = N;
		}
		
		System.out.println(cnt);
	}
}
