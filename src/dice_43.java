import java.util.Arrays;
//��ʵ�������ClimbingStairs_70����
//����˵ һ���������Կ�1-6��̨�� ��ô�����һ������n�� ���������̨������Ϊsһ���ж����ַ��� 
//��ʵ c[s]=c[s-1]+c[s-2]+c[s-3]+c[s-4]+c[s-5]+c[s-6]
//ֻ�������������˲��� Ϊn�� 
//��˲��ܹ� for(int i=7; i<=s; i++) ������
//���� ��n��Ϊѭ������   
//�ѿ�һ�� �� s=6-1�ķ��������
//�ѿ�2�� �� s=12-1�ķ��������
//�ѿ�3�� �� s=18-1�ķ��������
//�ѿ�4�� �� s=24-1�ķ��������
public class dice_43 {
	public void Probability(int number) {
		int[] p = new int[6 * number];
		p[0]=p[1]=p[2]=p[3]=p[4]=p[5]=1;
		for (int n = 2; n <= number; n++) {
			int s = n * 6;
			while (s-- >0) {//����Ӻ���ǰ��s
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