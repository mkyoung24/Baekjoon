import java.util.Scanner;

public class Alg1182 {
	
	static int N,S,cnt,sum;
	
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		S = scan.nextInt();
		
		arr = new int[N];
		cnt = 0;
		sum = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = scan.nextInt();
		}
		
		DFS(0);
		System.out.println(cnt);
	}
	
	public static void DFS(int start) {
		if(start == N) return;
		
		if(sum + arr[start] == S) cnt++;
		
		DFS(start+1);
		
		sum += arr[start];
		DFS(start+1);
		
		sum -= arr[start];
		
	}
	
}
