import java.util.List;
//backTracking 和书上的思路一样
//与PermutationsII_47相似 都是需要一个used 数组来表征是否用过

public class movingCount_67 {
	boolean[] arrived = null;
	int counts = 0;
	int rows = 0, cols = 0, th = 0;

	public int movingCount(int threshold, int rows, int cols) {
		arrived = new boolean[rows * cols];
		this.rows = rows;
		this.cols = cols;
		this.th = threshold;
		helper(0, 0);
		return counts;
	}

	private void helper(int r, int c) {
		if (r < 0 || r == rows || c < 0 || c == cols || arrived[r * cols + c])
			return;
		arrived[r * cols + c] = true;
		if (getDigitSum(r, c) <= th) {
			counts++;
			helper(r + 1, c);
			helper(r, c + 1);
		}
	}

	private int getDigitSum(int r, int c) {
		int sum = 0;
		while (r != 0 || c != 0) {
			sum += r % 10;
			sum += c % 10;
			r /= 10;
			c /= 10;
		}
		return sum;
	}
}