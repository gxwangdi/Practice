import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
	/**
	 * @param numCourses
	 *            a total of n courses
	 * @param prerequisites
	 *            a list of prerequisite pairs
	 * @return true if can finish all courses or false
	 */
	// BFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
		int[] degree = new int[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;

		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			degree[prerequisites[i][1]]++;
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
				count++;
			}
		}

		while (queue.size() != 0) {
			int course = queue.poll();
			for (int i = 0; i < graph.get(course).size(); i++) {
				int pointer = graph.get(course).get(i);
				degree[pointer]--;
				if (degree[pointer] == 0) {
					queue.add(pointer);
					count++;
				}
			}
		}
		if (count == numCourses) {
			return true;
		} else {
			return false;
		}
	}
    /* // Recursive DFS will have StackOverFlow on some test cases. 
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
		// status[i]=0 means not visited, or no edge
		// 1 means it has been taken as starting point,
		// 2 means it has finished as starting point.
		// Use this to avoid duplicate check.
		int[] status = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int[] prerequisite : prerequisites) {
			graph.get(prerequisite[0]).add(prerequisite[1]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (status[i] == 0 && !dfs(i, graph, status)) {
				return false;
			}
		}
		return true;
	}

	// Return false if there is cycle, duplicate visited node.
	private boolean dfs(int cur, List<List<Integer>> graph, int[] status) {
		// When someone starts from cur, and go back to cur somehow, then there
		// is a cycle.
		if (status[cur] == 1) {
			return false;
		}
		status[cur] = 1;
		for (int i : graph.get(cur)) {
			if (status[i] != 2 && !dfs(i, graph, status)) {
				return false;
			}
		}
		// now cur does not have cycle for sure.
		status[cur] = 2;
		return true;
	}
	*/
}
