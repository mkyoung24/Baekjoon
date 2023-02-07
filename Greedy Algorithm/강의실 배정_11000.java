import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Alg11000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] time = new int [N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken());	//시작시간
			time[i][1] = Integer.parseInt(st.nextToken());	//종료시간
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}				
				return o1[0] - o2[0];
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(time[0][1]);
		
		for(int i=1; i<N; i++) {
			if(time[i][0] < pq.peek()) {
				pq.add(time[i][1]);
			} else {
				pq.poll();
				pq.add(time[i][1]);
			}
		}
		
		System.out.println(pq.size());
	}

}
