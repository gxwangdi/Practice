import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	/**
	 * @param s: the IP string
	 * 
	 * @return: All possible valid IP addresses
	 */
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() < 4) {
			return res;
		}
		helper(res, s, 0, new StringBuilder(s.length() + 3), 0);
		return res;
	}// end of restoreIpAddresses

	private void helper(List<String> res, String s, int cur, StringBuilder prog, int level) {
		if (cur == s.length()) {
			if (level == 4) {
				res.add(prog.toString());
			}
			return;
		}

		if (level >= 4) {
			return;
		}

		if (prog.length() > 0) {
			prog.append(".");
		}

		if (s.charAt(cur) == '0') {
			prog.append(0);
			helper(res, s, cur + 1, prog, level + 1);
			return;
		}

		for (int i = 1; i <= 3; i++) {
			if (cur + i > s.length()) {
				continue;
			}
			String num = s.substring(cur, cur + i);
			int temp = Integer.parseInt(num);
			if (temp > 255) {
				continue;
			}
			StringBuilder sb = new StringBuilder(prog);
			sb.append(num);
			helper(res, s, cur + i, sb, level + 1);
		}
	}// end of helper
}
