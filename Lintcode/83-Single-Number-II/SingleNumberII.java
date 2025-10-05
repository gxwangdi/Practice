
public class SingleNumberII {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
	public int singleNumberII(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int[] digits = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int a : A) {
				digits[i] += (a >> i) & 1;
				digits[i] = digits[i] % 3;
			}
		}
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res |= (digits[i] << i);
		}
		return res;
	}
}
