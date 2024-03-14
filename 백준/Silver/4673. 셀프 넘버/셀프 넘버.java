public class Main {
	public static void main(String[] args) {
		boolean[] check = new boolean[10001];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10000; i++) {
			int n = d(i);
			
			if (n <= 10000) {
				check[n] = true;
			}
		}
		
		for (int i = 1; i <= 10000; i++) {
			if(check[i] == false) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static int d(int n) {
		int sum = n;
		
		while(n > 0) {
			sum = sum + (n % 10);
			n = n / 10;
		}
		
		
		return sum;
	}
}
