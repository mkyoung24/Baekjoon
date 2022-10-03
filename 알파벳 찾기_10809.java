import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alg10809 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		
		int alp [] = new int [26];
		
		for(int i=0; i<alp.length; i++) {
			alp[i] = -1;
		}
		
		for(int j=0; j<s.length(); j++) {
			char ch = s.charAt(j);
			if(alp[ch - 'a'] == -1) {
				alp[ch - 'a'] = j;
			}
		}
		
		for(int val : alp ) {
			System.out.print(val + " ");
		}
		
	}
}
