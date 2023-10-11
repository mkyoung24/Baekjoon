import java.util.Scanner;

public class Alg11729 {
	
	static StringBuilder sb = new StringBuilder();
	
	static int count = 0;
	
	static void move(int no, int x, int y) {
		if (no > 1) move(no - 1, x, 6 - x - y);
		
		sb.append(x + " ").append(y + "\n");
		count++;
		
		
		if (no > 1) move(no - 1, 6 - x - y, y);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		move(n, 1, 3);
		System.out.println(count);
		System.out.println(sb);
	}
}

