import java.util.HashSet;
import java.util.Set;

public class LineReflection {
    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0) {
            return true;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] point : points) {
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
            set.add(point[0] + "a" + point[1]);
        }
        long sum = min + max;
        for (int[] point : points) {
            String s = (sum-point[0]) + "a" + point[1];
            if (!set.contains(s)) {
                return false;
            }
        }
        return true;
    }
}





