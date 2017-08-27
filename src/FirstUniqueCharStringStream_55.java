import java.util.LinkedList;
import java.util.Queue;
//��FirstUniqueCharInString_387���� 
//�������� �����ַ���
//���� ��һ��queue���������������char

public class FirstUniqueCharStringStream_55 {
	Queue<Character> queue = new LinkedList<>();
	int[] count = new int[256];

	// Insert one char from stringstream
	public void Insert(char ch) {
		queue.offer(ch);
		count[ch]++;
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		while (!queue.isEmpty() && count[queue.peek()] > 1) {
			queue.poll();
		}
		return queue.isEmpty() ? '#' : queue.peek();
	}
}