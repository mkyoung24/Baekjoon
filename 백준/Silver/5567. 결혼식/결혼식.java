import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	
	static List<Integer>[] list;
	
	static int cnt = 0;
	
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1,0);
		
		for (int i = 2; i <= n; i++) {
			if (visited[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}
	
	public static void dfs(int start, int count) {
		if (count == 2) return;
		
		for (int i = 0; i < list[start].size(); i++) {
			int num = list[start].get(i);
			visited[num] = true;
			dfs(num, count+1);
		}
	}
}
