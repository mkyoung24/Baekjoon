import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Alg2644 {	
	
	static int n, a, b;
	
	static int [][] graph;
	
	static int [] ck;
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		a = scan.nextInt();
		b = scan.nextInt();
		graph = new int[n+1][n+1];
		int m = scan.nextInt();
		
		for(int i=0; i<m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		ck = new int[n+1];
		bfs(a,b);
		if(ck[b] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(ck[b]);
		}
	}
	
	public static void bfs(int a, int b) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(a);
		
		while(!q.isEmpty()) {
			int c = q.poll();
			
			if(c == b) {
				break;
			}
			
			for(int i=1; i<=n; i++) {
				if(graph[c][i] == 1 && ck[i] == 0) {
					ck[i] = ck[c] + 1;
					q.offer(i);
				}
			}
		}
	}
}
