import java.util.ArrayList;

public class ProductOfArrayExcludeItself {
	/**
	 * @param A
	 *            : Given an integers array A
	 * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... *
	 *          A[n-1]
	 */
	public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
		ArrayList<Long> res = new ArrayList<>();
		if (A == null || A.size() < 1) {
			return res;
		}
		long cur = A.get(0);
		res.add(1l);
		for (int i = 1; i < A.size(); i++) {
			res.add(cur);
			cur *= A.get(i);
		}
		cur = A.get(A.size() - 1);
		for (int i = A.size() - 2; i >= 0; i--) {
			res.set(i, res.get(i) * cur);
			cur *= A.get(i);
		}
		return res;
	}
}
