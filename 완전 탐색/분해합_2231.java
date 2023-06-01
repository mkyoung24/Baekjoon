import java.io.*;
import java.util.StringTokenizer;

public class Alg2231 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
				
		for(int i=1; i<N; i++) {			
			int sum = 0;
			int num = i;
			while(num != 0) {
				sum += num % 10;
				num = num / 10;
			}
			
			if(N == sum+i) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
		
	}
}
