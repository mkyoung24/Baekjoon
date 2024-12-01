import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int y = 0;
		int x = 0;
		
		
		if (H % (N+1) != 0) {
			y = H / (N+1) + 1; 
		} else {
			y = H / (N+1);
		}
		
		if (W % (M+1) != 0) {
			x = W / (M+1) + 1; 
		} else {
			x = W / (M+1);
		}
		
		int max = y * x;
		System.out.println(max);

	}
}
