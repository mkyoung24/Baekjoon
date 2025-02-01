import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		boolean[] box = new boolean[21];
		
		int n = scan.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			String str = scan.next();
			
			switch (str) {
				case "add" :
					box[scan.nextInt()] = true;
					break;
				case "remove" :
					box[scan.nextInt()] = false;
					break;
				case "check" :
					if (box[scan.nextInt()] == true) {
						sb.append(1 + "\n");
					} else {
						sb.append(0 + "\n");
					}
					break;
				case "toggle" :
					int x = scan.nextInt();
					if (box[x] == true) {
						box[x] = false;
					} else {
						box[x] = true;
					}
					break;
				case "all" :
					for (int j = 1; j <= 20; j++) {
						box[j] = true;
					}
					break;
				case "empty" : 
					for (int j = 1; j <= 20; j++) {
						box[j] = false;
					}
					break;
			}
			
		}
		
		System.out.println(sb);

	}
}
