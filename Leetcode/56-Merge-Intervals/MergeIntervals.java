import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size()<2) {
            return intervals;
        }
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start) {
                    return i1.start - i2.start;
                }
                return i1.end - i2.end;
            }
        });
        
        List<Interval> res = new ArrayList<>();
        Interval pivot = intervals.get(0);
        for (int i=1; i<intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (pivot.end < cur.start) {
                res.add(pivot);
                pivot = cur;
            } else {
                pivot.start = Math.min(pivot.start, cur.start);
                pivot.end = Math.max(pivot.end, cur.end);
            }
        }
        res.add(pivot);
        return res;
    }
}




