import java.util.*;
public class Alg2747 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int [n+1];
		a[0] = 0;
		a[1] = 1;
		
		for(int i=2; i<=n; i++) {
			a[i] = a[i-1] + a[i-2];
		}
		
		System.out.println(a[n]);
	}

}
