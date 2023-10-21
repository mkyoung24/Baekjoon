import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] num = new int[100][100];
		int area = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for (int j = a; j < a+10; j++) {
				for (int k = b; k < b+10; k++) {
					num[j][k] = 1;
				}
			}
		}
		
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if (num[j][k] == 1) {
					area += 1;
				}
			}
		}
		
		System.out.println(area);
	}
}
