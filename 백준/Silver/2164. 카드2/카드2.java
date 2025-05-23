import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		
		Queue<Integer> q = new LinkedList<>();
		
		if (N == 1) {
			System.out.println(1);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		for (int i = 1; i < N; i++) {
			q.poll();
			
			if (q.size() == 1) {
				System.out.println(q.peek());
				return;
			}
			
			int num = q.poll();
			q.add(num);
			
		}
		
		
	}
}
