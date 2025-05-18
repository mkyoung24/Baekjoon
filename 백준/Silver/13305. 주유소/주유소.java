import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dis = new int[N];
		int[] city = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i < N; i++) {
			dis[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		int money = 0;
		
		while(true) {
			int count = 1;
			int d = dis[count];
			for (int i = count + 1; i <= N; i++) {
				if (i == N) {
					money += city[count] * d;
					System.out.println(money);
					return;
				}
				
				if (city[count] > city[i]) {
					money += city[count] * d;
					d = dis[i];
					count = i;
				} else {
					d += dis[i];
				}
			}
			
		}
		
		
		
	}
}
