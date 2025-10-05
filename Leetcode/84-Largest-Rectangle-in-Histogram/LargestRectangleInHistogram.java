import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
    // public int largestRectangleArea(int[] heights) {
    //     Stack<Integer> stack = new Stack<>();
    //     int i = 0;
    //     int maxArea = 0;
    //     int[] h = new int[heights.length + 1];
    //     h = Arrays.copyOf(heights, heights.length + 1);
    //     while (i < h.length) {
    //         if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
    //             stack.push(i++);
    //         } else {
    //             int t = stack.pop();
    //             maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
    //         }
    //     }
    //     return maxArea;
    // }
    
    public int largestRectangleArea(int[] array) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int result = 0;
        for (int i = 0; i <= array.length; i++) {
            int cur = i == array.length ? 0 : array[i];//set the last bar equals 0
            while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
                int height = array[stack.pollFirst()];
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                result = Math.max(result, height * (i - left));
            }
            stack.offerFirst(i);
            
        }
        return result;
    }
}




