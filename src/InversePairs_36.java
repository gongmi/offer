import java.util.List;

public class InversePairs_36 {
	// 其实就是使用归并排序 其中加入求逆序对
	public int InversePairs(int[] a) {
		int[] temp = new int[a.length];
		return InversePairsCore(a, temp, 0, a.length - 1);
	}

	private int InversePairsCore(int[] a, int[] temp, int left, int right) {
		int res = 0;
		if (left < right) {
			int mid = left + (right - left) / 2;
			res += InversePairsCore(a, temp, left, mid);
			res += InversePairsCore(a, temp, mid + 1, right);
			res += Merge(a, temp, left, mid, right);
		}
		return res;

	}

	private int Merge(int[] a, int[] temp, int leftStart, int leftPos, int rightPos) {
		int rightStart = leftPos + 1;
		int tempPos = rightPos;
		int numElements = rightPos - leftStart + 1;
		int res = 0;
		while (leftPos >= leftStart && rightPos >= rightStart) {
			if (a[leftPos] > a[rightPos]) {
				res += rightPos - rightStart + 1; // 就是这句话嘛
				temp[tempPos--] = a[leftPos--];
			} else
				temp[tempPos--] = a[rightPos--];
		}
		while (leftPos >= leftStart)
			temp[tempPos--] = a[leftPos--];
		while (rightPos >= rightStart)
			temp[tempPos--] = a[rightPos--];

		for (int i = 0; i < numElements; i++, leftStart++)
			a[leftStart] = temp[leftStart];

		return res;

	}
}