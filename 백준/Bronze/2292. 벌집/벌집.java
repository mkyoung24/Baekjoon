import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ans = 1;
		int num = 1;
	
		
		while (num < n) {
			if (n == 1) return;
			
			num = num + 6 * ans;
			ans++;
		}
		
		System.out.println(ans);

	}
}
