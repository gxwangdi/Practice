import java.util.Arrays;

public class SearchForARange {
  public int[] searchRange(int[] nums, int target) {
      int[] res = new int[2];
      Arrays.fill(res, -1);
      if (nums == null || nums.length == 0) {
          return res;
      }
      res[0] = binarySearch(nums, target, true);
      if (res[0] == -1) {
          return res;
      }
      res[1] = binarySearch(nums, target, false);
      return res;
  }

  /**
   * @param isLowerBound true if it is looking for lower bound, otherwise for upper bound.
   * @return -1 if there is no match.
   */
  private int binarySearch(int[] nums, int target, boolean isLowerBound) {
      int left = 0;
      int right = nums.length -1;
      while (left+1 < right) {
          int mid = left + (right-left)/2;
          if (nums[mid] == target) {
              if (isLowerBound) {
                  right = mid;
              } else {
                  left = mid;
              }
              continue;
          }
          if (nums[mid] < target) {
              left = mid;
              continue;
          }
          if (nums[mid] > target) {
              right = mid;
          }
      }
      int res =-1;
      if (isLowerBound) {
          if (nums[left] == target) {
          res = left;
      } else if (nums[right] == target) {
          res = right;
      }
      } else { // for upper bound, check right first.
          if (nums[right] == target) {
          res = right;
      } else if (nums[left] == target) {
          res = left;
      }
      }
      return res;
  }
}
