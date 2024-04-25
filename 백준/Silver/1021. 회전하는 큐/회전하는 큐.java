import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> d = new LinkedList<>();
		int[] ans = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			d.offer(i);
		}
		
		int cnt = 0;
		
		for (int i = 0; i < M; i++) {
			int target = d.indexOf(ans[i]);
			int half;
			
			if (d.size() % 2 == 0) {
				half = d.size() / 2 - 1;
			} else {
				half = d.size() / 2;
			}
			
			if (target <= half) {
				for (int j = 0; j < target; j++) {
					int tmp = d.pollFirst();
					d.offerLast(tmp);
					cnt++;
				}
			} else {
				for (int j = 0; j < d.size() - target; j++) {
					int tmp = d.pollLast();
					d.offerFirst(tmp);
					cnt++;
				}
			}
			d.pollFirst();

		}
		
		System.out.println(cnt);

	}
}
