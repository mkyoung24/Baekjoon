import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		char[][] alp = new char[5][15];
		
		for (int i = 0; i < 5; i++) {
			String str = scan.nextLine();
			for (int j = 0; j < str.length(); j++) {
				alp[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (alp[j][i] == '\u0000') {
					continue;
				} else {
					sb.append(alp[j][i]);
				}
			}
		}
		
		System.out.print(sb);

	}
}
