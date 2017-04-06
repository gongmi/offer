public class HasSubtree_18 {
//	�Լ��������� ���ֺ�����һ�� ��������
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root2 == null || root1 == null)
			return false;
		if (same(root1, root2))
			return true;
		return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
	}
//�������� �����ж�root2 �ǲ���root1������ ��node��һ�� ����root2��С
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
