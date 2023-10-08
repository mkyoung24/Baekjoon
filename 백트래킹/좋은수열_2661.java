import java.util.Scanner;

public class Alg2661 {
	
	static int n;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		bt("");
	}
	
	public static void bt(String str) {
		 if (str.length() == n) {
	            System.out.println(str);
	            System.exit(0);
	     }
		 
		 for (int i = 1; i <= 3; i++) {
	            if(check(str + i)) bt(str + i);
	     }
	}
	
	public static boolean check(String str) {
		 for (int i = 1; i <= str.length() / 2; i++) {
	            String front = str.substring(str.length() -i * 2, str.length() - i);
	            String back = str.substring(str.length() - i, str.length());
	            if (front.equals(back)) return false;
	     }
	        
		 return true;
	}
}
