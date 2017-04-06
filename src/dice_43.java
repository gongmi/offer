import java.util.Arrays;
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
public class dice_43 {
	public void Probability(int number) {
		int[] p = new int[6 * number];
		p[0]=p[1]=p[2]=p[3]=p[4]=p[5]=1;
		for (int n = 2; n <= number; n++) {
			int s = n * 6;
			while (s-- >0) {//必须从后往前算s
				p[s]=0; 
				for (int j = 1; j <= 6; j++)
					p[s] += s - j < 0 ? 0 : p[s - j];
			}
		 }
		
		System.out.println(Arrays.toString(p));
	}
    public int Sum_Solution(int n) {
        int sum=n;
        boolean dummy=(n>0)&&((sum+=Sum_Solution(n-1))>0);
         return sum;
     }
}