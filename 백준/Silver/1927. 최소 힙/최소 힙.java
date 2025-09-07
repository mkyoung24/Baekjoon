import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());
			
			if (X == 0) {
				if (heap.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(heap.peek() + "\n");
					heap.poll();
				}
			} else {
				heap.offer(X);
			}
		}
		
		System.out.println(sb);

	}
}
