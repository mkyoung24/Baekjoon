import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int count = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int j=arr.length-1; j>=0; j--) {
			if(K >= arr[j]) {
				count += K / arr[j];
				K = K % arr[j];
				if(K == 0) break;
			}
		}
		
		System.out.println(count);

	}

}
