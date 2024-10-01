import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String s = br.readLine();
			
			if (s.equals(".")) {
				System.out.println(sb);
				return;
			}
			
			Stack<String> st = new Stack<>();
			boolean status = true;
			
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					st.add("cnt1");
				}
				
				if (s.charAt(i) == ')') {
					if (st.isEmpty()) {
						sb.append("no").append("\n");
						status = false;
						break;
					} else {
						if (st.peek() == "cnt1") {
							st.pop();
						} else {
							sb.append("no").append("\n");
							status = false;
							break;
						}
					}
				}
		
				if (s.charAt(i) == '[') {
					st.add("cnt2");
				}
				
				if (s.charAt(i) == ']') {
					if (st.isEmpty()) {
						sb.append("no").append("\n");
						status = false;
						break;
					} else {
						if (st.peek() == "cnt2") {
							st.pop();
						} else {
							sb.append("no").append("\n");
							status = false;
							break;
						}
					}
				}
						
			}
			
			if (status == true) {
				if (st.isEmpty()) {
					sb.append("yes").append("\n");
				} else {
					sb.append("no").append("\n");
				}
			}
			
		}

	}
}
	