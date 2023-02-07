import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int k = n;
		int j = m;
		int l;
		
		while(j != 0) {
			l = k;
			k = j;
			j = l % k;
		}
		
		System.out.println(k);
		System.out.println(m*n/k);
	}
}
