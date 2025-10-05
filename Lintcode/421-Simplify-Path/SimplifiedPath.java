import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifiedPath {
	/**
	 * @param path
	 *            the original path
	 * @return the simplified path
	 */

	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("/");
		String[] stubs = path.split("/+");
		List<String> dirs = new ArrayList<>();
		for (String s : stubs) {
			if ("..".equals(s)) {
				if (dirs.size() > 0) {
					dirs.remove(dirs.size() - 1);
				}
			} else if (!"".equals(s) && !".".equals(s)) {
				dirs.add(s);
			}
		}
		for (String s : dirs) {
			sb.append(s + "/");
		}
		if (sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/*
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "";
		}
		int cur = 0;
		while (cur < path.length() && path.charAt(cur) == ' ') {
			cur++;
		}
		Stack<String> stack = new Stack<>();
		stack.push("/");
		StringBuilder sb = new StringBuilder();
		while (cur < path.length()) {
			char c = path.charAt(cur);
			if (c == '/') {
				sb.append(c);
				if ("./".equals(sb.toString()) || "/".equals(sb.toString())) {
					// nothing
				} else if ("../".equals(sb.toString())) {
					if (!"/".equals(stack.peek())) {
						stack.pop();
					}
				} else {
					stack.push(sb.toString());
				}
				sb = new StringBuilder();
			} else {
				sb.append(c);
			}
			cur++;
		}
		cur = sb.length() - 1;
		while (cur >= 0 && (sb.charAt(cur) == ' ' || sb.charAt(cur) == '.')) {
			cur--;
		}
		if (cur != sb.length() - 1) {
			sb.delete(cur + 1, sb.length());
		}
		String res = sb.toString();
		while (!stack.empty()) {
			res = stack.pop() + res;
		}
		return res;
	}*/

}
