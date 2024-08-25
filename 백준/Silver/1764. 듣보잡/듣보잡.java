import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] d = new String[N];
		String[] b = new String[M];
		
		int count = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			d[i] = br.readLine();
		}
		
		for (int i = 0; i < M; i++) {
			b[i] = br.readLine();
		}
		
		Arrays.sort(d);
		Arrays.sort(b);
		
		
		if (N < M) {
			int num = 0;
			for (int i = 0; i < N; i++) {
				for (int j = num; j < M; j++) {
					if (d[i].equals(b[j])) {
						count++;
						sb.append(d[i] + "\n");
						num = j;
					}
				}
			}
		} else {
			int num = 0;
			for (int i = 0; i < M; i++) {
				for (int j = num; j < N; j++) {
					if (b[i].equals(d[j])) {
						count++;
						sb.append(b[i] + "\n");
						num = j;
					}
				}
			}
		}
		
		System.out.print(count + "\n" + sb);

	}
}
