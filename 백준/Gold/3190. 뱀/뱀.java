import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			map[n][m] = 1;
		}
		
		Deque<Spin> q = new ArrayDeque<>();
		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			q.offer(new Spin(time, dir));
		}
		
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		
		int y = 1;
		int x = 1;
		int time = 0;
		int dir = 1;	//0은 북, 1은 동, 2는 남, 3은 서
		Deque<Position> p = new ArrayDeque<>();
		p.offer(new Position(y,x));
		map[y][x] = 2;
		
		while (true) {
			int dY = y + dy[dir];
			int dX = x + dx[dir];
			
			time++;
			
			if (dY < 1 || dY > N ||dX < 1 || dX > N) break;		
				
			if (map[dY][dX] == 2) break;		
			
			if (map[dY][dX] == 0) {
				Position ps = p.removeFirst();
				map[ps.y][ps.x] = 0;
			}
			
			if (!q.isEmpty()) {
				if (time == q.getFirst().time) {
					Spin s = q.removeFirst();
					
					if (s.dir.equals("L"))
						dir = dir - 1 < 0 ? 3 : dir - 1;
					
					if (s.dir.equals("D"))
						dir = dir + 1 > 3 ? 0 : dir + 1; 
				}
			}
			
			map[dY][dX] = 2;
			p.offer(new Position(dY, dX));
			y = dY;
			x = dX;
		}
		
		System.out.println(time);
	}
}

class Spin {
	int time;
	String dir;
	
	Spin(int time, String dir) {
		this.time = time;
		this.dir = dir;
	}
}

class Position {
	int y, x;
	
	Position(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}
