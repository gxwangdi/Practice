import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
	/**
	 * @param height
	 *            : A list of integer
	 * @return: The area of largest rectangle in the histogram
	 */
	// Solution 2
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		int[] h = new int[height.length + 1];
		// add an 0, so it would calculate the last height
		h = Arrays.copyOf(height, height.length + 1);
		while (i < h.length) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, h[t]
						* (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		return maxArea;
	}

	// Solution 1
//	public int largestRectangleArea(int[] height) {
//		if (height == null || height.length == 0) {
//			return 0;
//		}
//
//		Stack<Integer> stack = new Stack<Integer>();
//		int max = 0;
//		for (int i = 0; i <= height.length; i++) {
//			int current = (i == height.length) ? -1 : height[i];
//			while (!stack.isEmpty() && current <= height[stack.peek()]) {
//				int h = height[stack.pop()];
//				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
//				max = Math.max(max, h * w);
//			}
//			stack.push(i);
//		}
//
//		return max;
//	}
}


