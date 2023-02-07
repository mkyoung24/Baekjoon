import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg1010 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		int m = n;
		
		do {
			m = (m % 10) * 10 + (((m / 10) + (m % 10)) % 10);
			++count; 
		}while(n != m);
			
		System.out.println(count);

	}

}
