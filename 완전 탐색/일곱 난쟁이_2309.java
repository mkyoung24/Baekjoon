import java.io.*;
import java.util.Arrays;

public class Alg2309 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] len = new int[9];
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			len[i] = Integer.parseInt(br.readLine());
			sum += len[i];
		}
		
		int ans = 0;
		
		loop :
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				ans = sum;
				ans = ans - len[j];
				ans = ans - len[i];
				if(ans == 100) {
					len[j] = 0;
					len[i] = 0;
					break loop;
				}
			}
		}
		
		Arrays.sort(len);
		
		for(int i=0; i<len.length; i++) {
			if(len[i] != 0) {
				sb.append(len[i]).append("\n");
			}
		}
		
		System.out.println(sb);
					
	}
}
