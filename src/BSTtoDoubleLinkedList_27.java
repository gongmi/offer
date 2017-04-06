import java.util.*;

//这个题和BinaryTreeToLinkedList_114相似
//只不过是中序遍历 因此可以用中序遍历的stack方法
//来改变node之间的left 和right
public class BSTtoDoubleLinkedList_27 {
	public TreeNode Convert(TreeNode root) {
		if (root == null)
			return null;
		Deque<TreeNode> stack = new LinkedList<>();
		pushAllLeft(root, stack);
		TreeNode prev = null;
		boolean isFirst = true;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			pushAllLeft(cur.right, stack);
			if (isFirst) {
				root = cur;
				isFirst = false;
				prev = cur;
			} else {
				prev.right = cur;
				cur.left = prev;
				prev = cur;
			}
		}
		return root;
	}

	private void pushAllLeft(TreeNode root, Deque<TreeNode> stack) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	//	与BinaryTreeToLinkedList_114 top答案相似
	// 改进之后使用了 书上的方法 其实就是中序遍历用一个全局变量prev来存上一个结点
	// （书上是pLastNodeInList 作为变量传来传去）
	//  返回值 是返回最左（书上没有返回值）
	protected TreeNode prev = null;

	public TreeNode Convert3(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = Convert3(root.left); // 左
		root.left = prev;
		if (prev != null)
			prev.right = root; // 把当前节点与prev连起来
		prev = root; // 中
		Convert3(root.right); // 右
		return root.left == null ? root : left;
	}
}
