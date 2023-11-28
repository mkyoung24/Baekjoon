import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(s);
		System.out.println(st.countTokens());
	}

}