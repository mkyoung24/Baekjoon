import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int[] num = new int[P];
		
		if (N == 0) {
			System.out.println(1);
			return;
		}
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		if (N == P && score <= num[num.length - 1]) {
			System.out.println(-1);
		} else {
			int rank = 1;
			for (int i = 0; i < num.length; i++) {
				if (score < num[i]) {
					rank++;
				} else {
					break;
				}
			}
			System.out.println(rank);
		}
		
	}
}
