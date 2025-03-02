import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());
		int[] arr = new int[20];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int test = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			for (int j = 0; j < 20; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int k = 1; k < 20; k++) {
				for (int l = 0; l < k; l++) {
					if (arr[l] > arr[k]) cnt++;
				}
			}
			
			sb.append(test + " " + cnt + "\n");
			
		}
		
		System.out.println(sb);
		
	}
}
