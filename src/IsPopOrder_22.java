import java.util.Stack;

public class IsPopOrder_22 {
	// �������ϵ�˼·
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> s = new Stack<>();

		for (int i = 0, j = 0; i < popA.length; i++) {
			if (!s.isEmpty() && s.peek() == popA[i])
				s.pop();
			else {
				if (j == popA.length)
					return false;
				while (pushA[j] != popA[i]) {
					s.push(pushA[j]);
					j++;
					if (j == popA.length)
						return false;
				}
				j++;
			}
		}
		return true;
	}

	// ���Ǳ��˵�˼·
	// forѭ����pushA�е�����ջ
	// while�ж�peek�Ƿ���pop��һ�� һ���Ļ�pop����
	// ������ջΪ��˵���ɹ�
	public boolean IsPopOrder3(int[] pushA, int[] popA) {
		Stack<Integer> s = new Stack<>();
		int j = 0;
		for (int i = 0; i < popA.length; i++) {
			s.push(pushA[i]);
			while ((!s.isEmpty()) && s.peek() == popA[j]) {
				s.pop();
				j++;
			}
		}
		return s.isEmpty();
	}
}
