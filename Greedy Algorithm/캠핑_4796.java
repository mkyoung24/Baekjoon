import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg4796 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int i = 1;
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int day = 0;
			if(L == 0 && P == 0 && V == 0) break;
			if(V%P > L) {
				day = (V/P*L) + L;
			} else {
				day = (V/P*L) + (V%P);
			}
			sb.append("Case " + i + ": " + day + "\n");
			i++;
		}
		br.close();
		System.out.print(sb);

	}

}
