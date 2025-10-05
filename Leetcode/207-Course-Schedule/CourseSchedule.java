import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        // status[i]=0 means not visited, or no edge
        // 1 means it has been taken as starting point, 
        // 2 means it has finished as starting point. 
        // Use this to avoid duplicate check. 
        int[] status = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite:prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int i=0; i<numCourses; i++) {
            if (status[i] == 0 && !dfs(i, graph, status)) {
                return false;
            }
        }
        return true;
    }
    
    // Return false if there is cycle, duplicate visited node. 
    private boolean dfs(int cur, List<List<Integer>> graph, int[] status) {
        // When someone starts from cur, and go back to cur somehow, then there is a cycle. 
        if (status[cur] == 1) {
            return false;
        }
        status[cur] =1;
        for (int i : graph.get(cur)) {
            if (status[i]!=2 && !dfs(i, graph, status)) {
                return false;
            }
        }
        // now cur does not have cycle for sure. 
        status[cur] = 2;
        return true;
    }
    
    /*
    // TLE  
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            if (map.containsKey(pre[0])) {
                List<Integer> v = map.get(pre[0]);
                v.add(pre[1]);
            } else {
                List<Integer> v = new ArrayList<>();
                v.add(pre[1]);
                map.put(pre[0], v);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Integer key : map.keySet()) {
            set.add(key);
            List<Integer> values = map.get(key);
            for (Integer v : values) {
                set.add(v);
                if (isCycle(v, map, set)) {
                    return false;
                }
                set.remove(v);
            }
            set.remove(key);
        }
        return true;
    }// end of canFinish
    
    private boolean isCycle(int key, Map<Integer, List<Integer>> map, Set<Integer> set) {
        if (!map.containsKey(key)) {
            return false;
        }
        
        List<Integer> values = map.get(key);
        for (Integer v : values) {
            if (set.contains(v)) {
                return true;
            }
            set.add(v);
            if (isCycle(v, map, set)) {
                return true;
            }
            set.remove(v);
        }
        return false;
    }// end of isCycle
    */
}




