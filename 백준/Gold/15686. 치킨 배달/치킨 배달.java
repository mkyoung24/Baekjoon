import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] city;
	
	static int min = Integer.MAX_VALUE;
	
	static int N, M;
	
	static ArrayList<Point> chicken = new ArrayList<>();
	
	static boolean[] visited;
	
	static ArrayList<Point> house = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		city = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1) house.add(new Point(i, j));
				else if (city[i][j] == 2) chicken.add(new Point(i, j));
			}
		}
		
		visited = new boolean[chicken.size()];
		bt(0, 0);
		System.out.println(min);
		
	}
	
	public static void bt(int cnt, int idx) {
		if (cnt == M) {
			int total = 0;
			for (int i = 0; i < house.size(); i++) {
				int sum = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (visited[j] == true) {
						int dist = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
						sum = Math.min(sum, dist);
					}
				}
				total += sum;
			}
			
			min = Math.min(total, min);
			return;
		}
		
		for (int i = idx; i < chicken.size(); i++) {
			if (visited[i] == false) {
				visited[i] = true;
				bt(cnt + 1, i + 1);
				visited[i] = false;
			}
		}
		
	}
	
	public static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
