import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] num = new int [11];
		
		num[1] = 1;
		num[2] = 2;
		num[3] = 4;
		
		for (int i = 4; i < 11; i++) {
			num[i] = num[i-1] + num[i-2] + num[i-3];
		}
		
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(num[n]).append("\n");		
		}
		
		System.out.println(sb);

	}
}
