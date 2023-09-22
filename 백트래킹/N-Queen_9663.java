import java.util.Scanner;

public class Alg9663 {
	
	static int N;
	
	static int count = 0;
	
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		arr = new int[N];
		
		bt(0);		
		System.out.println(count);
	}
	
	public static void bt(int start) {
		if (start == N) {
			count++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[start] = i;
			
			if (check(start)) {
				bt(start + 1);
			}
		}	
	}
	
	public static boolean check(int start) {
		for (int i = 0; i < start; i++) {
			if (arr[start] == arr[i]) {
				return false;
			} else if (Math.abs(start - i) == Math.abs(arr[start] - arr[i])) {
				return false;
			}
		}
		
		return true;
		
	}
}
