import java.util.Scanner;

public class Alg9466 {
	
	static int graph[];
	
	static boolean visited[];
	
	static boolean finished[];
	
	static int T,n;
	
	static int count;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		
		for(int i=0; i<T; i++) {
			n = scan.nextInt();
			
			graph = new int[n+1];
			visited = new boolean[n+1];
			finished = new boolean[n+1];
			count = 0;

			for(int j=1; j<=n; j++) {
				graph[j] = scan.nextInt();
			}
			
			for(int k=1; k<=n; k++) {
				if(!visited[k])
					dfs(k);
			}
			
			System.out.println(n - count);
		}
		
	}
	
	public static void dfs(int a) {

		visited[a] = true;
		
		int next = graph[a];
		
		if(!visited[next]) {
			dfs(next);
		}
		
		if(visited[next] && !finished[next]) {
			for(int t = next; t != a; t = graph[t])
				count++;
			count++;
		}
		
		finished[a] = true;
	
	}
}
