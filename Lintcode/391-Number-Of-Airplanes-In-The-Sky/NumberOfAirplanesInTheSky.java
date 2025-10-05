import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class NumberOfAirplanesInTheSky {
	/**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
	public int countOfAirplanes(List<Interval> airplanes) {
		if (airplanes == null || airplanes.size() == 0) {
			return 0;
		}
		List<Point> timePoints = new ArrayList<>(airplanes.size() * 2);
		for (Interval flight : airplanes) {
			timePoints.add(new Point(flight.start, 1));
			timePoints.add(new Point(flight.end, -1));
		}

		Collections.sort(timePoints, new Comparator<Point>() {
			public int compare(Point a, Point b) {
				if (a.time == b.time) {
					return a.delta - b.delta;
				} else {
					return a.time - b.time;
				}
			}
		});

		int max = 0;
		int sum = 0;

		for (Point p : timePoints) {
			sum += p.delta;
			max = Math.max(sum, max);
		}
		return max;
	}

	private static class Point {
		int time;
		int delta;

		Point(int time, int delta) {
			this.time = time;
			this.delta = delta;
		}
	}
}
