import java.util.*;
//与PermutationsII_47相似 只不过是数字改成了字母
public class Permutation_28 {
	ArrayList<String> res = new ArrayList<>();
	char[] array = null;
	boolean[] used = null;

	public ArrayList<String> Permutation(String str) {
		array = str.toCharArray();
		Arrays.sort(array);
		used = new boolean[array.length];
		backtrack(new StringBuilder());
		return res;

	}

	private void backtrack(StringBuilder sb) {
		for (int i = 0; i < array.length - 1; i++) {
			if (used[i] || (i > 0 && used[i - 1] && array[i - 1] == array[i]))
				continue;
			sb.append(array[i]);
			used[i] = true;
			if (sb.length() == array.length)
				res.add(new String(sb));
			else
				backtrack(sb);
			sb.deleteCharAt(sb.length() - 1);
			used[i] = false;
		}
	}
}
