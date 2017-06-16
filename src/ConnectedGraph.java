import java.util.*;
//nowcoder上面的一道求连通分量的题目 但是一直0.% 但我本地是对的
//与ConnectedComponents_323相似


public class ConnectedGraph {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		HashSet<Integer>[] list = new HashSet[n + 1];
		for (int i = 1; i <= n; i++)
			list[i] = new HashSet<Integer>();
		while (true) {
			int left = in.nextInt();
			int right = in.nextInt();
			if (left == 0)
				break;
			list[left].add(right);
			list[right].add(left);
		}
		boolean visited[] = new boolean[n + 1];
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				DFS(visited, list, i);
				count++;
			}
		}
        if (count >1)
		System.out.println("NO");
        else
        System.out.println("YES");
	}

	private static void DFS(boolean visited[], HashSet<Integer>[] list, int i) {
		if (!visited[i]) {
			visited[i] = true;
			for (int n : list[i])
				DFS(visited, list, n);
		}
	}
}
