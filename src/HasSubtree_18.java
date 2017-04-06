public class HasSubtree_18 {
//	自己做出来的 发现和书上一样 哈哈哈哈
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root2 == null || root1 == null)
			return false;
		if (same(root1, root2))
			return true;
		return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
	}
//辅助函数 用来判断root2 是不是root1的子树 即node都一样 但是root2更小
	public boolean same(TreeNode root1, TreeNode root2) {
		if (root2 == null)
			return true;
		if (root1 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return same(root1.left, root2.left) && same(root1.right, root2.right);
	}
}
