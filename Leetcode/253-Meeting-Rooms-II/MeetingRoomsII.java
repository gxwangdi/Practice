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
public class MeetingRoomsII {

  public int minMeetingRooms(int[][] intervals) {
        int[][] items = new int[intervals.length*2][intervals[0].length];
        for(int i=0; i<intervals.length; i++) {
            items[i*2][0] = intervals[i][0];
            items[i*2][1] = 1;
            items[i*2+1][0] = intervals[i][1];
            items[i*2+1][1] = -1;
        }
        Arrays.sort(items, (a,b) -> {
            if (a[0] == b[0]) {
                return a[1];
            }
            return a[0] - b[0];
            });
        int max = 0;
        int count =0;
        for(int[] item : items) {
            count += item[1];
            max = Math.max(max, count);
        }
        return max;
    }
    
    // public int minMeetingRooms(Interval[] intervals) {
    //     if (intervals == null || intervals.length == 0) {
    //         return 0;
    //     }
    //     List<Pair> list = new ArrayList<>(intervals.length*2);
    //     for (Interval i : intervals) {
    //         list.add(new Pair(i.start, 1));
    //         list.add(new Pair(i.end, -1));
    //     }
    //     Collections.sort(list, new Comparator<Pair>(){
    //         public int compare(Pair p1, Pair p2) {
    //             if (p1.time != p2.time) {
    //                 return p1.time - p2.time;
    //             }
    //             return p1.plusOne - p2.plusOne;
    //         }
    //     });
    //     int count = 0;
    //     int max = 0;
    //     for (int i=0; i<list.size(); i++) {
    //         Pair p = list.get(i);
    //         count += p.plusOne;
    //         max = Math.max(max, count);
    //     }
    //
    //     return max;
    // }
    //
    // private static class Pair {
    //     public int time;
    //     public int plusOne;
    //     public Pair(int t, int p) {
    //         time = t;
    //         plusOne = p;
    //     }
    // }// end of Pair
}
