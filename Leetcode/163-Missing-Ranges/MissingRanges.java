import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    
    // pre and after can not handle Integer.MIN_VALUE, can extend to long. 
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int pre = lower-1; // Pay attention to the preprocessing.
        for (int i=0; i<=nums.length; i++) {
            int after = i==nums.length?upper+1:nums[i];  // and the upper+1
            if (after - pre > 1) {
                res.add(getRange(pre+1, after-1));
            }
            pre = after;
        }
        return res;
    }
    
    // left <= right.
    private String getRange(int left, int right) {
        StringBuilder sb = new StringBuilder();
        sb.append(left);
        if (left == right) {
            return sb.toString();
        }
        sb.append("->").append(right);
        return sb.toString();
    }
    
    /* // Well, this implementation does not work well for not understanding the assumption properly
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || lower > upper) {
            return res;
        }
        if (nums.length == 0 || ((lower >= nums[nums.length-1] || upper <= nums[0]) && upper!=lower)) {
            res.add(getRange(lower, upper));
            return res;
        }
        
        // init start/end if it is possible that they do not have overlapping part with given array.
        int left = 0;
        while (left < nums.length && lower >= nums[left]) {
            left++;
        }
        int start = Math.min(lower, nums[left-1]);
        
        int right = nums.length-1;
        while (right >=0 && upper <= nums[right]) {
            right--;
        }
        int end = Math.max(upper, nums[right]);
        for (int i=left; i<=right; i++) {
            if (nums[i]-start >1) {
                if (start == lower) {
                    res.add(getRange(start, nums[i]-1));
                } else {
                    res.add(getRange(start+1, nums[i]-1));
                }
            }
            start = nums[i];
        }
        if (end - start > 1) {
            if (end == upper) {
                res.add(getRange(start+1, end));
            } else {
                res.add(getRange(start+1, end-1));
            }
        }
        return res;
    }
    
    // left <= right.
    private String getRange(int left, int right) {
        StringBuilder sb = new StringBuilder();
        sb.append(left);
        if (left == right) {
            return sb.toString();
        }
        sb.append("->").append(right);
        return sb.toString();
    }
    */
}








