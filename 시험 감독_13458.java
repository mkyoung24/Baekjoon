import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg13458 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());	//총감독관
        int c = Integer.parseInt(st.nextToken());	//부감독관
        
        long answer = 0;
        
        for (int i = 0; i < n; i++) {
            if(arr[i] > b) {
            	answer++;
            	answer += (arr[i] - b) / c;
            	if((arr[i] - b) % c != 0) answer++;
            } else {
            	answer++;
            }
        }
        
        System.out.println(answer);
		
	}
}
