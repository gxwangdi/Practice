import java.util.ArrayList;
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
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || newInterval == null) {
            return res;
        }
        int position = 0;
        for (Interval i : intervals) {
            if (i.end < newInterval.start) {
                res.add(i);
                position++;
            } else if (i.start > newInterval.end) {
                res.add(i);
            } else {
                newInterval.start = Math.min(i.start, newInterval.start);
                newInterval.end = Math.max(i.end, newInterval.end);
            }
        }
        res.add(position, newInterval);
        return res;
    }
}



