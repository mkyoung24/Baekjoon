import java.util.Scanner;

public class Alg15649 {
	
	static int N,M;
	
	static int[] ans;
	
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		
		ans = new int[M];
		visited = new boolean[N];
		
		DFS(0);
	}
	
	public static void DFS(int start) {
		if(start == M) {
			for(int i=0; i<M; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[start] = i+1;
				DFS(start+1);
				visited[i] = false;
			}
		}		
	}
	
}
