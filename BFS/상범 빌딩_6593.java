import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alg6593 {
	
	static char [][][] graph;
	
	static boolean [][][] visited;
	
	static int L,R,C;
	
	static StringBuilder sb = new StringBuilder();;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true){
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) {
				System.out.println(sb.toString());
				return;
			}
			
			graph = new char[L][R][C];
			visited = new boolean[L][R][C];
			
			int x = 0;
			int y = 0;
			int z = 0;
			
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					String s = br.readLine();
					for(int k=0; k<C; k++) {
						graph[i][j][k] = s.charAt(k);
						if(graph[i][j][k] == 'S') {
							z = i;
							y = j;
							x = k;
							graph[i][j][k] = '.';
						}
					}
				}
				br.readLine();
			}
			bfs(x,y,z);
		}
	}
	
	public static void bfs(int x, int y, int z) {
		Queue<int[]> q = new LinkedList<>();
				
		q.offer(new int[] {x,y,z,0});
		
		visited[z][y][x] = true;
		
		int[] dz = {0, 0, 0, 0, 1, -1};
		int[] dy = {0, 0, 1, -1, 0, 0};
		int[] dx = {1, -1, 0, 0, 0, 0};
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int px = poll[0];
			int py = poll[1];
			int pz = poll[2];
			int move = poll[3];
						
			if(graph[pz][py][px] == 'E') {
				sb.append("Escaped in " + move + " minute(s).\n");
				return;
			} 
			
			for(int i=0; i<6; i++) {
				int nz = pz + dz[i];
				int ny = py + dy[i];
				int nx = px + dx[i];
				
				if(nx < 0 || nx > C - 1 || ny < 0 || ny > R - 1 || nz < 0 || nz > L - 1) continue;
				
				if(visited[nz][ny][nx]) continue;
				if(graph[nz][ny][nx] == '.' || graph[nz][ny][nx] == 'E') {
					visited[nz][ny][nx] = true;
					q.add(new int[] {nx, ny, nz, move+1});
				} 
			}
		}
		sb.append("Trapped!\n");
	}
	
}
