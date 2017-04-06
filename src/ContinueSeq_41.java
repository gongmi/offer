import java.util.ArrayList;
//two pointer ��TwoSumII_167����
public class ContinueSeq_41 {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		int start = 1;
		int end = 2;
		int cur = start + end;
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum<3) return res;
		while (start < (sum + 1) / 2) {
			if (cur == sum) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = start; i <= end; i++)
					list.add(i);
				res.add(list);
				end++;     //��������������
				cur += end;//
			} else if (cur < sum) {
				end++;
				cur += end;
			} else if (cur > sum) {
				cur -= start;
				start++;
			}
		}
		return res;
	}
//	������һ���ַ��� ��ţ���� top
}