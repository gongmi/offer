public class replaceSpace_4 {
	public String replaceSpace(StringBuffer str) {
		StringBuffer res = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				res.append("%20");
			else
				res.append(str.charAt(i));
		}
		return new String(res);
	}
}
