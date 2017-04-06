import java.util.*;

public class GetLeastKnumbers_30 {
	// O��n��+O(klogn)
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if (k > input.length)
			return res;
		// ��һ��С����
		PriorityQueue<Integer> heap = new PriorityQueue<>();// ��һ��С����
		for (int i : input)
			heap.offer(i);
		// ȡ��ǰk����
		while (res.size() != k)
			res.add(heap.poll());
		return res;
	}

	// O��k��+O(nlogk)
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
		// ��һ���󶥶� sizeά����k
		PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		for (int i : input) {
			if(heap.size()<k||heap.size()==k&&i<heap.peek())
			heap.offer(i);
			if (heap.size() == k+1)
				heap.poll();
		}
		return new ArrayList<>(heap);
	}
}
