import java.util.List;
//�����õ����ϵ�˼· ֻ���� ���������������õ�ѭ�� ���������ϵĵݹ�
//
public class GetNumbersOfK_38 {
	public int GetNumberOfK(int[] array, int k) {
		int start = FirstK(array, k, 0, array.length - 1);
		int end = LastK(array, k, 0, array.length - 1);
		return start == -1 ? 0 : end - start + 1;
	}

private	int FirstK(int[] a, int k, int left, int right) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (a[mid] < k)
				left = mid + 1;
			else if (a[mid] > k)
				right = mid - 1;
			else if (mid == 0 || a[mid - 1] != k)
				return mid;
			else
				right = mid - 1;
		}
		return -1;
	}

private	int LastK(int[] a, int k, int left, int right) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (a[mid] < k)
				left = mid + 1;
			else if (a[mid] > k)
				right = mid - 1;
			else if (mid == a.length - 1 || a[mid + 1] != k)
				return mid;
			else
				left = mid + 1;
		}
		return -1;
	}
}