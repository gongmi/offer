public class Power_11 {
	// -3>>1 不是-1 而是-2 负数的右移不是除以2
//	我的答案 用的剑指offer书上的思路 递归
	public double Power2(double base, int exponent) {
		if (base == 0)
			return 0;
		double temp = helper(base, Math.abs(exponent));
		if (exponent < 0)
			return 1.0 / temp;
		return temp;
	}

	private double helper(double base, int exponent) {
		if (exponent == 0)
			return 1;

		double res = helper(base, exponent >> 1);
		res *= res;
		if ((exponent & 1) == 1)
			res *= base;
		return res;
	}
//别人的迭代
/** * 1.全面考察指数的正负、底数是否为零等情况。 
 * * 2.写出指数的二进制表达，例如13表达为二进制1101。 
 * * 3.举例:10^1101 = 10^0001*10^0100*10^1000。 
 * * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。 
 * */
	public double Power(double base, int exponent) {
		double res = 1;
		double cur = base;
		int temp = 0;

		if (exponent > 0)
			temp = exponent;
		else if (exponent < 0) {
			if (base < 0)
				throw new RuntimeException("当指数为负数时 底数不能为0");
			temp = -exponent;
		} else
			return 1;
		while (temp != 0) {
			if ((temp & 1) == 1)
				res *= cur;
			cur *= cur;
			temp = temp >> 1;
		}

		if (exponent < 0)
			return 1.0 / res;
		return res;
	}

}
