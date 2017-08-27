import java.util.Stack;

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

	// top答案不用递归 这是前序遍历 这个很难想到啊
	public boolean verifyPreorder(int[] preorder) {
		int low = Integer.MIN_VALUE;
		Stack<Integer> path = new Stack<>();
		for (int p : preorder) {
			if (p < low)
				return false;
			while (!path.empty() && p > path.peek())
				low = path.pop();
			path.push(p);
		}
		return true;
	}

	// 只有 O(1) extra space
	public boolean verifyPreorder2(int[] preorder) {
		int low = Integer.MIN_VALUE, i = -1;
		for (int p : preorder) {
			if (p < low)
				return false;
			while (i >= 0 && p > preorder[i])
				low = preorder[i--];
			preorder[++i] = p;
		}
		return true;
	}
}
