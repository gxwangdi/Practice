import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

public class MergeIntervals {
	/**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size()==0) {
            return intervals;
        }
        
        // Sort first! 
        Collections.sort(intervals, intervalComparator);
        
        for (int i=0; i<intervals.size()-1; i++) {
            if (intervals.get(i).end < intervals.get(i+1).start) {
                continue;
            }
            int start = intervals.get(i).start;
            int end = Math.max(intervals.get(i).end, intervals.get(i+1).end);
            Interval inval = new Interval(start, end);
            intervals.remove(i+1);
            intervals.set(i, inval);
            i--;
        }
        return intervals;
    }
    
    private Comparator<Interval> intervalComparator = new Comparator<Interval>(){
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    };
}
