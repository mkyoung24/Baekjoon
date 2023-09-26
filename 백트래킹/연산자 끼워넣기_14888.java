import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg14888 {
	
	static int[] num;
	
	static int[] op = new int [4];	//+, -, *, /
		
	static int max = Integer.MIN_VALUE;
	
	static int min = Integer.MAX_VALUE;
	
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		num = new int [n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		bt(1, num[0]);
		
		System.out.println(max);
		System.out.println(min);		
	}
	
	public static void bt(int start, int sum) {
		if (start == n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < op.length; i++) {
			if (op[i] > 0) {
				switch(i) {
				  case 0:
					  op[0]--;
					  sum += num[start];
					  bt(start+1, sum);
					  sum -= num[start];
					  op[0]++;
					  break;
				  case 1:
					  op[1]--;
					  sum -= num[start];
					  bt(start+1, sum);
					  sum += num[start];
					  op[1]++;
					  break;
				  case 2:
					  op[2]--;
					  sum *= num[start];
					  bt(start+1, sum);
					  sum /= num[start];
					  op[2]++;
					  break;
				  case 3:
					  op[3]--;
					  sum /= num[start];
					  bt(start+1, sum);
					  sum *= num[start];
					  op[3]++;
					  break;
				}
			}
		}
		
	}
}
