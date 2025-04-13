import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			boolean check1 = true;
			boolean check2 = true;
			boolean check3 = true;
			
			if (str.equals("end")) {
				System.out.println(sb);
				break;
			} 
			
			if (!(str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u"))) {
				check1 = false;
			} 
			
			int vowel = 0;			//모음
			int consonant = 0;		//자음
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
					vowel = vowel + 1;
					consonant = 0;
					
					if (vowel == 3) {
						check2 = false;
					}
					
				} else {
					consonant = consonant + 1;
					vowel = 0;
					
					if (consonant == 3) {
						check2 = false;
					}
				}
			}
			
			for (int i = 0; i < str.length() - 1; i++) {
				if (str.charAt(i) == str.charAt(i+1)) {
					if (str.charAt(i) == 'e' || str.charAt(i) == 'o') {
						check3 = true;
					} else {
						check3 = false;
					}
				}
			}
			
			if (check1 == true && check2 == true && check3 == true) {
				sb.append("<" + str + "> is acceptable." + "\n");
			} else {
				sb.append("<" + str + "> is not acceptable." + "\n");
			}
					
		}
		
	}
}
