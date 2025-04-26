import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] sw = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if (gender == 1) {
				for (int k = 1; m * k <= n; k++) {
					if (sw[m * k] == 0) {
						sw[m * k] = 1;
					} else {
						sw[m * k] = 0;
					}
				}
			} else {
				sw[m] = sw[m] == 0 ? 1 : 0;
				for (int j = 1; j <= n/2; j++) {
					int left = m - j;
					int right = m + j;
					
					if (left < 1 || right > n) break;
					
					if (sw[left] == sw[right]) {
						sw[left] = sw[left] == 0 ? 1 : 0;
						sw[right] = sw[right] == 0 ? 1 : 0;
					} else {
						break;
					}
					
				}
			}
		}
		
		for (int l = 1; l <= n; l++) {
			System.out.print(sw[l] + " ");
			
			if (l % 20 == 0) System.out.println();
		}
		
	}
}
