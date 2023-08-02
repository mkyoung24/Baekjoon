import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg5427 {
	
	static char [][] graph;
	
	static boolean [][] visited;
	
	static Queue<Point> fire;
	
	static int n,w,h;
	
	static int[] dx = {1, -1, 0, 0};
	
	static int[] dy = {0, 0, 1, -1};
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		n = Integer.parseInt(br.readLine());
		int x = 0, y = 0;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			graph = new char[h][w];
			visited = new boolean[h][w];
			fire = new LinkedList<>();
			
			for(int j=0; j<h; j++) {
				String s = br.readLine();
				for(int k=0; k<w; k++) {
					graph[j][k] = s.charAt(k);
					if(graph[j][k] == '@') {
						x = k;
						y = j;
						graph[j][k] = '.';
					} else if(graph[j][k] == '*') {
						fire.add(new Point(k,j));
					}
				}
			}
			escape(x,y);
		}
		System.out.println(sb.toString());
	}
	
	public static void escape(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		visited[y][x] = true;
		q.offer(new Point(-1, -1));
		q.offer(new Point(x,y));
		int time = -1;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(now.x == -1 && now.y == -1) {
				burn();
				if(!q.isEmpty())
					q.offer(now);
				time++;
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx < 0 || nx >= w || ny < 0 || ny >= h) {
					sb.append(time+1 + "\n");
					return;
				}
				if(graph[ny][nx] == '.' && !visited[ny][nx]) {
					q.offer(new Point(nx, ny));
					visited[ny][nx] = true;
				}
			}
		}
		
		 sb.append("IMPOSSIBLE\n");
	}
	
	public static void burn() {
		int size = fire.size();
		
		for(int s = 0; s < size; s++) {
			Point now = fire.poll();
			
			for(int i=0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < w && ny < h && (graph[ny][nx] == '.' || graph[ny][nx] == '@')) {
                    fire.offer(new Point(nx, ny));
                    graph[ny][nx] = '*';
                }
			}
		}
	}
	
	public static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
