public class Poker_44 {
	// top 不用排序的
	// 必须满足两个条件
	// 1. 除0外没有重复的数
	// 2. max - min < 5
	public boolean isContinuous(int[] numbers) {
		if (numbers.length != 5)
			return false;
		int min = 14;
		int max = -1;
		int flag = 0; // 用一个32位的int的位数 来表示这一位上有没有数
		for (int n : numbers) {
			if (n < 0 || n > 13)
				return false;
			if (n == 0)
				continue;
			if (((flag >> n) & 1) == 1) // 如果这一位曾经被置为1了
				return false;
			flag |= (1 << n); // 把第n位置为1
			if (n > max)
				max = n;
			if (n < min)
				min = n;
			if (max - min >= 5)
				return false;
		}
		return true;
	}
}
