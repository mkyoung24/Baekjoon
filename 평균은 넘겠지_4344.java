import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg4344 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr2 = new int[n];
			int sum = 0;
			for(int j=0; j<n; j++) {
				arr2[j] = Integer.parseInt(br.readLine());
				sum += arr2[j];
			}
			
			double avg = sum / n;
			double count = 0;
			
			for(int k=0; k<arr2.length; k++) {
				if(avg < arr2[k]) {
					count++;
				}
			}
			
			System.out.printf("%.3f%%\n", (count/n)*100);
			
		
		}
		
		br.close();
		

	}

}
