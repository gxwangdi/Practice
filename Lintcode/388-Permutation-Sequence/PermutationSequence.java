import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {
	/*
	 * @param n: n
	 * 
	 * @param k: the k th permutation
	 * 
	 * @return: return the k-th permutation
	 */
	public String getPermutation(int n, int k) {
		List<Integer> num = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++)
			num.add(i);
		int[] fact = new int[n]; // factorial
		fact[0] = 1;
		for (int i = 1; i < n; i++)
			fact[i] = i * fact[i - 1];
		k = k - 1;
		StringBuilder sb = new StringBuilder();
		for (int i = n; i > 0; i--) {
			int ind = k / fact[i - 1];
			k = k % fact[i - 1];
			sb.append(num.get(ind));
			num.remove(ind);
		}
		return sb.toString();
	}
}
