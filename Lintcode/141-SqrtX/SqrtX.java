
public class SqrtX {
	/**
     * @param x: An integer
     * @return: The sqrt of x
     */
	public int sqrt(int x) {
		if (x <= 0) {
			return 0;
		}
		long start = 1;
		long end = x;
		long mid;
		long cur;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			cur = mid * mid;
			if (cur <= x) {
				start = mid;
			} else {
				end = mid;
			}
		}
		cur = end * end;
		if (cur <= x) {
			return (int) end;
		}
		cur = start * start;
		if (cur <= x) {
			return (int) start;
		}
		return -1;
	}
}
