import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg8979 {
	
	static int n,k;
	
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][3];

		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[num][0] = g;
			arr[num][1] = s;
			arr[num][2] = b;
		}
		
		int rank = 1;
		
		for (int i = 1; i <= n; i++) {
			if (arr[i][0] > arr[k][0]) rank++;
			
			if (arr[i][0] == arr[k][0] && arr[i][1] > arr[k][1]) rank++;
			
			if (arr[i][0] == arr[k][0] && arr[i][1] == arr[k][1] && arr[i][2] > arr[k][2]) rank++;
		}
		
		
		System.out.println(rank);
	}
	

}
