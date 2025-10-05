import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
	/**
	 * @param numCourses
	 *            a total of n courses
	 * @param prerequisites
	 *            a list of prerequisite pairs
	 * @return the course order
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		if (prerequisites == null || prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++) {
				res[i] = i;
			}
			return res;
		}
		// List<Set<Integer>> graph = new ArrayList<>(numCourses);
		List<List<Integer>> graph = new ArrayList<>(numCourses);
		// Set<Integer>[] graph = new HashSet<Integer>[numCourses];
		int[] count = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int[] pre : prerequisites) {
			count[pre[0]]++;
			graph.get(pre[1]).add(pre[0]);
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (count[i] == 0) {
				queue.offer(i);
			}
		}
		int cur = 0;
		while (!queue.isEmpty()) {
			int from = queue.poll();
			res[cur++] = from;
			for (int to : graph.get(from)) {
				count[to]--;
				if (count[to] == 0) {
					queue.offer(to);
				}
			}
		}
		if (cur == numCourses) {
			return res;
		}
		return new int[0];
	}
}
