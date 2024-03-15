import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int count = 1, sum = 0;
		
		while (true) {
			if (n <= sum + count) {
				if (count % 2 == 1) {
					System.out.println((count - (n - sum -1)) + "/" + (n - sum));
					break;
				} else {
					System.out.println((n - sum) + "/" + (count - (n - sum -1)));
					break;
				}
			} else {
				sum += count;
				count++;
			}
		}
		
	}
}
