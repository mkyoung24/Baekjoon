import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] num = new int[3][4];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			} 
		}
		
		for (int i = 0; i < 3; i++) {
			int front = 0;			//배
			for (int j = 0; j < 4; j++) {
				if (num[i][j] == 0) {
					front++;
				} 
			}
			
			if (front == 0) {
				sb.append('E').append("\n");
			} else if (front == 1) {
				sb.append('A').append("\n");
			} else if (front == 2) {
				sb.append('B').append("\n");
			} else if (front == 3) {
				sb.append('C').append("\n");
			} else {
				sb.append('D').append("\n");
			}
		}
		
		System.out.println(sb);

	}
}
