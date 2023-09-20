import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Alg1759 {
	static int L,C;
	
	static char[] arr, pw;
	
	static boolean[] isVowels, visited;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		visited = new boolean[C];
		isVowels = new boolean[C];
		pw = new char[C];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr); 	//a, c, i, s, t, w
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				isVowels[i] = true;
			}
		}
		
		Ans(0, 0, 0, 0);
		
		System.out.println(sb);
	}
	
	public static void Ans(int start, int end, int vowelsCnt, int consonantsCnt) {		
		if (start == L && vowelsCnt >= 1 && consonantsCnt >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(pw[i]);
				}
				sb.append("\n");
				return;		
		}
		
		for (int i = end; i < arr.length; i++) {
			int vowels = vowelsCnt;				//모음
			int consonants = consonantsCnt;		//자음
			
			if (!visited[i]) {
				if (isVowels[i]) {
					vowels++;
				} else {
					consonants++;
				}
				
				visited[i] = true;
				pw[start] = arr[i];
				Ans(start+1, i, vowels, consonants);
				visited[i] = false;
			}
		}		
	}

}
