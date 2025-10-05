import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	/**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> graph = new HashMap<>();
		Map<String, Integer> distance = new HashMap<>();

		dict.add(start);
		dict.add(end);

		bfs(graph, distance, start, end, dict);

		dfs(res, graph, distance, new ArrayList<String>(), end, start);

		return res;
	}

	private void dfs(List<List<String>> res, Map<String, List<String>> graph, Map<String, Integer> distance,
			List<String> path, String cur, String end) {
		path.add(cur);
		if (cur.equals(end)) {
			Collections.reverse(path);
			res.add(new ArrayList<String>(path));
			Collections.reverse(path);
		} else {
			for (String next : graph.get(cur)) {
				if (distance.containsKey(next) && distance.get(next) < distance.get(cur)) {
					dfs(res, graph, distance, path, next, end);
				}
			}
		}
		path.remove(path.size() - 1);
	}

	private void bfs(Map<String, List<String>> graph, Map<String, Integer> dis, String start, String end,
			Set<String> dict) {
		Queue<String> q = new LinkedList<>();
		q.offer(start);
		dis.put(start, 0);
		for (String s : dict) {
			graph.put(s, new ArrayList<String>());
		}

		while (!q.isEmpty()) {
			String cur = q.poll();

			List<String> nextLev = getNext(cur, dict);
			for (String next : nextLev) {
				graph.get(next).add(cur);
				if (!dis.containsKey(next)) {
					dis.put(next, dis.get(cur) + 1);
					q.offer(next);
				}
			}
		}
	} // end of bfs

	private List<String> getNext(String cur, Set<String> dict) {
		List<String> res = new ArrayList<>();
		char[] arr = cur.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			char temp = arr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				arr[i] = c;
				String s = new String(arr);
				if (dict.contains(s)) {
					res.add(s);
				}
			}
			arr[i] = temp;
		}
		return res;
	}// end of getNext
}
