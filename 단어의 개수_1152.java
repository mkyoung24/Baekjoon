import java.util.Scanner;
import java.util.StringTokenizer;

public class Alg1152 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		StringTokenizer st = new StringTokenizer(s); /*토큰은 분리된 문자열 조각으로
													 *StringTokenizer클래스는 하나의 문자열을 여러 개의 토큰으로
													 *분리하는 클래스 
													 */
		System.out.println(st.countTokens()); //총 토큰의 개수를 리턴
	}

}
