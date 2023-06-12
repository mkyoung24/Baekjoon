import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Alg11724 {
	
	static boolean[] visited;
	
	static int[][] graph;
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		
		int count = 0;
		
		for(int i = 1; i <= N; i++) {
			if (!visited[i]) {
				//dfs(i);
				//bfs(i);
				dfs2(i);
				count += 1;
			}
		}
	
		System.out.println(count);
	}
	
	public static void dfs(int start) {
			if (visited[start]) {
				return;
			}
			visited[start] = true;
			
			for(int i = 1; i <= N; i++) {
				if(graph[start][i] == 1) {
					dfs(i);				
				}
			}
	}
	
	public static void dfs2(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		while (!stack.isEmpty()) {
			int curr = stack.pop();
			
			if (visited[curr]) continue;
			
			visited[curr] = true;
			for (int i = 1; i <= N; i++) {
				if (graph[curr][i] == 1) {
					stack.push(i);
				}
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i = 1; i <= N; i++) {
				if(graph[curr][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}					
	}	
}
