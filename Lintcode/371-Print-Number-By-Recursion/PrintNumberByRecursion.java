import java.util.ArrayList;
import java.util.List;

public class PrintNumberByRecursion {
	/**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
     
     
    /* // iterative approach
    public List<Integer> numbersByRecursion(int n) {
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (count < n) {
            int size = res.size();
            if (size == 0) {
                for (int i=1; i<=9; i++) {
                    res.add(i);
                }
                count++;
                continue;
            }
            for (int i=0; i<size; i++) {
                for (int j=0; j<=9; j++) {
                    int temp = res.get(i) * 10+j;
                    if (temp != 0) {
                        res.add(temp);
                    }
                }
            }
            count++;
        }
        return res;
    }*/
    
    
    // Recursive approach. 
	public List<Integer> numbersByRecursion(int n) {

		List<Integer> res = new ArrayList<>();
		if (n < 1) {
			return res;
		}
		num(n, 0, res);
		return res;
	}

	private void num(int n, int ans, List<Integer> res) {
		if (n == 0) {
			if (ans != 0) {
				res.add(ans);
			}
			return;
		}
		for (int i = 0; i <= 9; i++) {
			num(n - 1, ans * 10 + i, res);
		}
	}
}
