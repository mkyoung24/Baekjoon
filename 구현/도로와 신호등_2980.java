import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg2980 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//신호등 갯수
		int L = Integer.parseInt(st.nextToken());	//도로 길이
		
		int[][] light = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			light[i][0] = Integer.parseInt(st.nextToken());		//위치
			light[i][1] = Integer.parseInt(st.nextToken());		//빨간불
			light[i][2] = Integer.parseInt(st.nextToken());		//파란불
		}
		
		int time = 0;
		int l = 0;
		int idx = 0;
		
		while(l < L) {
			if(idx == N) {
				time += L - l;
				break;
			}
			
			int d = light[idx][0];
			int r = light[idx][1];
			int g = light[idx][2];
			
			time += d - l;
			l = d;
			
			if (time % (r + g) < r) {
				time += r - (time % (r + g));
			}
			
			idx++;
		}
		
		System.out.println(time);
		
	}
}
