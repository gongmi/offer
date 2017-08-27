import java.util.Stack;

//������ConstructBinaryTree_105_106����
//���ǵݹ�Ĵ�����������������
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

	// top�𰸲��õݹ� ����ǰ����� ��������뵽��
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

	// ֻ�� O(1) extra space
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
