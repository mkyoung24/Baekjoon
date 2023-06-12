import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Alg1260 {
	
	static StringBuilder sb = new StringBuilder();
	
	static boolean[] visitied;
	
	static int[][] graph;
	
	static Stack<Integer> s = new Stack<>();
	
	static Queue<Integer> q = new LinkedList<Integer>();
	
	static int node, line, start;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		visitied = new boolean[node+1];
		graph = new int[node+1][node+1];
		
		for(int i=0; i<line; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			
			graph[a][b] = graph[b][a] = 1;
		}
		
		dfs(start);
		sb.append("\n");
		visitied = new boolean[node+1];
		bfs(start);
		
		System.out.println(sb);
	}
	
	public static void dfs(int start) {
		
		visitied[start] = true;
		sb.append(start + " ");
		
		for(int i=0; i <= node; i++) {
			if(graph[start][i] == 1 && !visitied[i]) {
				dfs(i);
			}
		}
		
	}
	
	public static void bfs(int start) {
		
		q.add(start);
		visitied[start] = true;
		
		while(!q.isEmpty()) {
			start = q.poll();
			sb.append(start + " ");
			
			for(int i=1; i<=node; i++) {
				if(graph[start][i] == 1 && !visitied[i]) {
					q.add(i);
					visitied[i] = true;
				} 
			}
		}
		
	}

}
