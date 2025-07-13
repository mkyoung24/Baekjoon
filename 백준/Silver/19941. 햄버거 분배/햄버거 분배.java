import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[] ham = new char[N];
		int people = 0;
		
		String str = br.readLine();
		for (int i = 0; i < N; i++) {
			ham[i] = str.charAt(i);
		}
		
		for (int i = 0; i < N; i++) {
			if (ham[i] == 'P') {
				int max = Math.min(i + K, N - 1);
				int min = Math.max(i - K, 0);
				
				for (int j = min; j <= max; j++) {
					if (ham[j] == 'H') {
						people++;
						ham[j] = 'X';
						break;
					}
				}
			}
		}
		
		System.out.println(people);
		
	}
}
