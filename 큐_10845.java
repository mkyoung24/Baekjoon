import java.util.*;

public class Alg10845 {
	public static int[] que;
	public static int size = 0;
	public static int front = 0;
	public static int back = 0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = scan.nextInt();
		que = new int[N];
		
		for(int i=0; i<N; i++) {
			String str = scan.next();
			switch(str) {
				case "push" :
					push(scan.nextInt());
					break;
				
				case "front" :
					sb.append(front()).append('\n');
					break;
					
				case "back" :
					sb.append(back()).append('\n');
					break;
					
				case "size" :
					sb.append(size()).append('\n');
					break;
					
				case "empty" :
					sb.append(empty()).append('\n');
					break;
					
				case "pop" :
					sb.append(pop()).append('\n');
					break;
			}
		}
		
		System.out.println(sb);
	}
	
	public static void push(int n) {
		que[back] = n;
		size++;
		back++;
	}
	
	public static int pop() {
		if(size == 0) {
			return -1;
		} else {
			int num = que[front];
			que[front] = 0;
			front++;
			size--;
			return num;
		}
	}
	
	public static int size() {
		return size;
	}
	
	public static int empty() {
		if(size == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int front() {
		if(size == 0) {
			return -1;
		} else {
			return que[front];
		}
	}
	
	public static int back() {
		if(size == 0) {
			return -1;
		} else {
			return que[back-1];
		}
		
	}

}
