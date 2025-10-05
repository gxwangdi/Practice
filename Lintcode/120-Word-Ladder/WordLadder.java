import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	/**
	 * @param start, a string
	 * @param end, a string
	 * @param dict, a set of string
	 * @return an integer
	 */
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || end == null || start.length() != end.length() || dict == null) {
			return 0;
		}
		Queue<String> q = new LinkedList<>();
		q.offer(start);
		q.offer(null); // mark one level.
		int level = 1;
		Set<String> visited = new HashSet<>();
		visited.add(start);

		while (!q.isEmpty()) {
			String s = q.poll();
			if (s == null) {
				level++;
				if (!q.isEmpty()) {
					q.offer(null);
				}
				continue;
			}
			if (s.equals(end)) {
				return level;
			}
			char[] arr = s.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char temp = arr[i];
				for (char a = 'a'; a <= 'z'; a++) {
					arr[i] = a;
					String cand = new String(arr);
					if (cand.equals(end)) { // check end here.
						return level + 1;
					}
					if (dict.contains(cand) && !visited.contains(cand)) {
						q.offer(cand);
						visited.add(cand);
					}
				}
				arr[i] = temp;
			}
		} // end of q.isEmpty()
		return 0;
	}
}
