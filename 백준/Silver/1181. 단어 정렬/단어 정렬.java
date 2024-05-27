import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] st = new String[N];
		
		for (int i = 0; i < N; i++) {
			st[i] = br.readLine();
		}
		
		Arrays.sort(st, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				if (o1.length() - o2.length() == 0) return o1.compareTo(o2);
				
				return o1.length() - o2.length();
			}
		});
		
		String[] str = Arrays.stream(st).distinct().toArray(String[]::new);
		
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}

	}
}
