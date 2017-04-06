import java.util.*;

//������BinaryTreeToLinkedList_114����
//ֻ������������� ��˿��������������stack����
//���ı�node֮���left ��right
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

	//	��BinaryTreeToLinkedList_114 top������
	// �Ľ�֮��ʹ���� ���ϵķ��� ��ʵ�������������һ��ȫ�ֱ���prev������һ�����
	// ��������pLastNodeInList ��Ϊ����������ȥ��
	//  ����ֵ �Ƿ�����������û�з���ֵ��
	protected TreeNode prev = null;

	public TreeNode Convert3(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = Convert3(root.left); // ��
		root.left = prev;
		if (prev != null)
			prev.right = root; // �ѵ�ǰ�ڵ���prev������
		prev = root; // ��
		Convert3(root.right); // ��
		return root.left == null ? root : left;
	}
}
