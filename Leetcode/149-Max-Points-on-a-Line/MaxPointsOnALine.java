import java.util.HashMap;
import java.util.Map;


class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        Map<Double, Integer> map = new HashMap<>();
        int max = 1;
        for (int i=0; i<points.length; i++) {
            // Shared point changed, map should be cleared and serve the new point
            map.clear();
            
            // Maybe all points contained in the list are the same points,and same points' k is 
            // represented by Integer.MIN_VALUE
            map.put((double)Integer.MIN_VALUE, 1);
            
            int dup = 0;
            for (int j=i+1; j<points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                    continue;
                }
                
                // look 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
                // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
                // problem

                // if the line through two points are parallel to y coordinator, then K(slop) is 
                // Integer.MAX_VALUE
                double key=points[j].x - points[i].x == 0 ? 
                    Integer.MAX_VALUE :
                    0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 2);
                }
            }// end of j loop     
            
            for (int temp: map.values()) {
                // duplicate may exist
                if (temp + dup > max) {
                    max = temp + dup;
                }
            }
        }
        return max;
    }// end of maxPoints     
}




