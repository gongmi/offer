import java.util.*;

public class GetLeastKnumbers_30 {
	// O（n）+O(klogn)
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if (k > input.length)
			return res;
		// 建一个小顶堆
		PriorityQueue<Integer> heap = new PriorityQueue<>();// 建一个小顶堆
		for (int i : input)
			heap.offer(i);
		// 取出前k个数
		while (res.size() != k)
			res.add(heap.poll());
		return res;
	}

	// O（k）+O(nlogk)
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
		// 建一个大顶堆 size维持在k
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
