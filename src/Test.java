public class Test {
	public static void main(String[] args) {
		System.out.println(count2(100));
	}

	public static int count(int n) {
		int res = 0;
		while (n > 0) {
			res += n / 5;
			n = n / 5;
		}
		return res;
	}

	public static int count2(int n) {
		int res = 0;
		for (int i = 1; i <= n; i++) {
			int j = i;
			while (j % 5 == 0) {
				res++;
				j = j / 5;
			}
		}
		return res;
	}
}