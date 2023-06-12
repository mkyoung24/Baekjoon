import java.util.*;

public class Alg10448 {	
	static int[] num = new int [45];
	static int count(int n) {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			sum += i;
		}
		return sum;
	}
	
	static int check(int n) {
		int ck = 0;
		for(int i=1; i<45; i++) {
			for(int j=1; j<45; j++) {
				for(int k=1; k<45; k++) {
					if(n == num[i] + num[j] + num[k]) {
						ck = 1;
					} 
				}
			}
		}
		return ck;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();
		for(int j=1; j<45; j++) {
			num[j] = count(j);
		}
		
		for(int i=0; i<K; i++) {
			int n = scan.nextInt();
			System.out.println(check(n));
		}

	}
}
