import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] minus = br.readLine().split("-");
		int sum = Integer.MAX_VALUE;
		
		for (int i = 0; i < minus.length; i++) {
			int temp = 0;
			
			String[] plus = minus[i].split("\\+");
			
			for (int j = 0; j < plus.length; j++) {
				temp += Integer.parseInt(plus[j]);
			}
			
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		
		System.out.println(sum);
		
	}
}
