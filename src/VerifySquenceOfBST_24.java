//这道题和ConstructBinaryTree_105_106很像
//都是递归的处理左子树和右子树
public class VerifySquenceOfBST_24 {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0)
			return false;
		return helper(sequence, 0, sequence.length - 1);

	}

	private boolean helper(int[] sequence, int left, int right) {
		if (left >= right)
			return true;
		int midd = sequence[right];
		boolean smaller = true;
		int small_index = right - 1;
		for (int i = left; i < right; i++) {
			if (smaller && sequence[i] > midd) {
				smaller = false;
				small_index = i - 1;
			} else if (!smaller && sequence[i] < midd)
				return false;
		}
		return helper(sequence, left, small_index) && helper(sequence, small_index + 1, right - 1);
	}
}
