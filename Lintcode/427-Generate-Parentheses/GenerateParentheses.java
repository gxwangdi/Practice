import java.util.ArrayList;
import java.util.List;


public class GenerateParentheses {
	/**
	 * @param n
	 *            n pairs
	 * @return All combinations of well-formed parentheses
	 */
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<>();
		if (n <= 0) {
			return res;
		}
		generate(res, "", n, n);
		return res;
	}

	private void generate(List<String> res, String parent, int left, int right) {
		if (left > right) {
			return;
		}
		if (left == 0 && right == 0) {
			res.add(parent);
			return;
		}
		if (left > 0) {
			generate(res, parent + "(", left - 1, right);
		}
		if (right > 0) {
			generate(res, parent + ")", left, right - 1);
		}
	}
    
    /* // This does not work, cannot generate "(())(())". 
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n<1) {
            return res;
        }
        Set<String> currLevel = new HashSet<>();
        Set<String> nextLevel = new HashSet<>();
        currLevel.add("()");
        while (n>1) {
            for (String s : currLevel) {
                String s1 = "()"+s;
                String s2 = s+"()";
                String s3 = "("+s+")";
                nextLevel.add(s1);
                nextLevel.add(s2);
                nextLevel.add(s3);
            }
            currLevel = nextLevel;
            nextLevel = new HashSet<>();
            n--;
        }
        for (String s: currLevel) {
            res.add(s);
        }
        return res;
    }
    */
}


