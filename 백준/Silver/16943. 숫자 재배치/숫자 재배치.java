import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static String a;
	
	static int[] arr;
	
	static int b, ans;
	
	static boolean[] isSelected;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = st.nextToken();
		b = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[a.length()];
		arr = new int[a.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = a.charAt(i) - '0';
		}
		
		ans = -1;
		bt(0,0);
		System.out.println(ans);
	}
	
	public static void bt(int depth, int num) {
		if (depth == a.length()) {
			ans = Math.max(ans, num);
			return;
		}
		
		for (int i = 0; i < a.length(); i++) {
			if (isSelected[i]) continue;
			if (depth == 0 && arr[i] == 0) continue;
			if (num * 10 + arr[i] > b) continue;
			isSelected[i] = true;
			bt(depth + 1, num * 10 + arr[i]);
			isSelected[i] = false;
		}
	}
}
