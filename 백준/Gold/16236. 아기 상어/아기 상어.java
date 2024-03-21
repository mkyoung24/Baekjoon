import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, sharkRow, sharkCol, sharkSize = 2, time, eatCnt = 0;
	
	static int[][] num;
	
	static int[] dy = {1, -1, 0, 0};
	
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
				if (num[i][j] == 9) {
					sharkRow = i;
					sharkCol = j;
					
					num[i][j] = 0;
				}
			}
		}
		
		int timeSum = 0;
		
		while (bfs())
			timeSum += time;
		
		System.out.println(timeSum);
		
	}
	
	public static boolean bfs() {
		time = 0;
		
		if (eatCnt == sharkSize) {
			eatCnt = 0;
			sharkSize++;
		}
		
		boolean[][] visited = new boolean[N][N];
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(sharkRow, sharkCol, 0));
		visited[sharkRow][sharkCol] = true;
		
		int minRow = Integer.MAX_VALUE;
		int minCol = Integer.MAX_VALUE;
		int minTime = Integer.MAX_VALUE;
		
		while (!q.isEmpty()) {
			Node a = q.poll();
			
			if (a.time >= minTime)
				break;
			
			for (int i = 0; i < 4; i++) {
				int dr = a.row + dy[i];
				int dc = a.col + dx[i];
				
				if (dr < 0 || dr >= N || dc < 0 || dc >= N) continue;
				
				if (visited[dr][dc]) continue;
				
				if (num[dr][dc] > sharkSize) continue;
				
				if (num[dr][dc] > 0 && num[dr][dc] < sharkSize) {
					if (dr < minRow) {
						minRow = dr;
						minCol = dc;
						minTime = a.time + 1;
					} else if (dr == minRow) {
						if (dc < minCol) {
							minCol = dc;
							minTime = a.time + 1;
						}
					}
				}
				
				q.offer(new Node(dr, dc, a.time+1));
				visited[dr][dc] = true;
				
			}
		}
		
		if (minTime == Integer.MAX_VALUE) {
			return false;
		} else {
			sharkRow = minRow;
			sharkCol = minCol;
			eatCnt++;
			time = minTime;
			num[sharkRow][sharkCol] = 0;
			
			return true;
		}
		
	}
}

class Node {
	int row, col, time;
	
	Node(int row, int col, int time) {
		this.row = row;
		this.col = col;
		this.time = time;
	}
}
