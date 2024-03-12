import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			sb.append(solve(br.readLine())).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	public static String solve(String s) {
		Stack<Character> stack = new Stack<>();
		
		if (s.charAt(0) == ')') {
			return "NO";
		} else {
			stack.push(s.charAt(0));
		}
		
		for (int i = 1; i < s.length(); i++) {
			try {
				if (s.charAt(i) == '(') {
					stack.push(s.charAt(i));
				} else {
					stack.pop();
				}
			} catch(EmptyStackException e) {
				return "NO";
			}
		}
		
		if (stack.isEmpty()) {
			return "YES";
		}
		
		return "NO";
	}
}
