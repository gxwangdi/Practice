import java.util.ArrayList;

//Definition of Interval:
class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class InsertInterval {
	/**
	 * Insert newInterval into intervals.
	 * 
	 * @param intervals
	 *            : Sorted interval list.
	 * @param newInterval
	 *            : A new interval.
	 * @return: A new sorted interval list.
	 */
	// Elegant solution from jiuzhang.
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		if (newInterval == null || intervals == null) {
			return intervals;
		}

		ArrayList<Interval> results = new ArrayList<>();
		int insertPos = 0;
		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				results.add(interval);
				insertPos++;
			} else if (interval.start > newInterval.end) {
				results.add(interval);
			} else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}
		results.add(insertPos, newInterval);
		return results;
	}

	// my implementation just thinks too much unnecessary stuff! 
//	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
//			Interval newInterval) {
//		if (newInterval == null) {
//			return intervals;
//		}
//		if (intervals == null) {
//			intervals = new ArrayList<>();
//		}
//		if (intervals.size() == 0) {
//			intervals.add(newInterval);
//			return intervals;
//		} else if (newInterval.end < intervals.get(0).start) {
//			intervals.add(0, newInterval);
//			return intervals;
//		}
//
//		int i = 0;
//		boolean isInserted = false;
//		while (i < intervals.size()) {
//			if (intervals.get(i).end >= newInterval.start
//					&& intervals.get(i).start <= newInterval.end) {
//				newInterval.start = Math.min(newInterval.start,
//						intervals.get(i).start);
//				newInterval.end = Math.max(newInterval.end,
//						intervals.get(i).end);
//				intervals.set(i, newInterval);
//				isInserted = true;
//				break;
//			}
//
//			i++;
//		}
//		if (!isInserted) {
//			intervals.add(newInterval);
//			return intervals;
//		}
//		while (i < intervals.size() - 1
//				&& newInterval.end >= intervals.get(i + 1).start) {
//			newInterval.start = Math.min(newInterval.start,
//					intervals.get(i + 1).start);
//			newInterval.end = Math.max(newInterval.end,
//					intervals.get(i + 1).end);
//			intervals.remove(i + 1);
//			intervals.set(i, newInterval);
//		}
//		return intervals;
//	}
}
