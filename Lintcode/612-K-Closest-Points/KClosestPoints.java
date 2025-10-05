import java.util.Comparator;
import java.util.PriorityQueue;

// Definition for a point.
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

public class KClosestPoints {
	/**
	 * @param points
	 *            a list of points
	 * @param origin
	 *            a point
	 * @param k
	 *            an integer
	 * @return the k closest points
	 */
	public Point[] kClosest(Point[] points, final Point origin, int k) {
		PriorityQueue<Point> maxHeap = new PriorityQueue<>(k,
				new Comparator<Point>() {
					@Override
					public int compare(Point a, Point b) {
						int diff = getDistance(b, origin)
								- getDistance(a, origin);
						if (diff == 0) {
							diff = b.x - a.x;
						}
						if (diff == 0) {
							diff = b.y - a.y;
						}
						return diff;
					}
				});

		for (Point p : points) {
			maxHeap.add(p);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		Point[] result = new Point[k];
		while (k - 1 >= 0) {
			result[--k] = maxHeap.poll();
		}
		return result;
	}

	private int getDistance(Point a, Point b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}
}
