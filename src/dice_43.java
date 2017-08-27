import java.util.Arrays;
import java.util.HashMap;
//其实这道题与ClimbingStairs_70相似
//就是说 一个人它可以跨1-6级台阶 那么如果它一共跨了n步 请问它跨的台阶总数为s一共有多少种方法 
//其实 c[s]=c[s-1]+c[s-2]+c[s-3]+c[s-4]+c[s-5]+c[s-6]
//只不过这里限制了步数 为n步 
//因此不能够 for(int i=7; i<=s; i++) 来求了
//而是 以n作为循环变量   
//把跨一步 的 s=6-1的方法求出来
//把跨2步 的 s=12-1的方法求出来
//把跨3步 的 s=18-1的方法求出来
//把跨4步 的 s=24-1的方法求出来
//即对于数组p
//0   1  2  3  4  5   6    7  8   9   10  11 12   13  14  15 16 17 
//[1, 1, 1, 1, 1, 1,  0,   0, 0,  0,   0, 0,  0,   0, 0,  0, 0, 0]
//[0, 1, 2, 3, 4, 5,  6,   5, 4,  3,   2, 1,  0,   0, 0,  0, 0, 0]
//[0, 0, 1, 3, 6, 10, 15, 21, 25, 27, 27, 25, 21, 15, 10, 6, 3, 1]

public class dice_43 {
	public void Probability(int number) {
		int[] p = new int[6 * number];
		p[0] = p[1] = p[2] = p[3] = p[4] = p[5] = 1;
		System.out.println(Arrays.toString(p));
		for (int n = 2; n <= number; n++) {
			int s = n * 6;
			while (s-- > 0) {// 必须从后往前算s 每一个s都等于它前面的6个加起来
				p[s] = 0;
				for (int j = 1; j <= 6; j++)
					p[s] += s - j < 0 ? 0 : p[s - j];
			}
			System.out.println(Arrays.toString(p));
		}

	}
}