import java.util.*;
public class Alg2675 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		for(int i=0; i<n; i++) {
			int num = scan.nextInt();
			String str = scan.next();
			
			for(int j=0; j<str.length(); j++) {
				for(int k=0; k<num; k++) {
					System.out.print(str.charAt(j));
				}
			}
			System.out.println();
			
			
		}
		
		

	}

}
