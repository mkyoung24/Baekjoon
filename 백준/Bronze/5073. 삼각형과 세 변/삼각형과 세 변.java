import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] num = new int[3];
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[0] = Integer.parseInt(st.nextToken());
			num[1] = Integer.parseInt(st.nextToken());
			num[2] = Integer.parseInt(st.nextToken());
			
			if (num[0] == 0 && num[1] == 0 && num[2] == 0) {
				System.out.println(sb);
				break;
			}
			
			Arrays.sort(num);
			
			if (num[2] >= (num[1] + num[0])) {
				sb.append("Invalid").append("\n");
			} else if (num[2] == num[1] && num[1] == num[0]) {
				sb.append("Equilateral").append("\n");
			} else if (num[2] != num[1] && num[1] != num[0]) {
				sb.append("Scalene").append("\n");
			} else {
				sb.append("Isosceles").append("\n");
			}
			
		}
		
	}
}
