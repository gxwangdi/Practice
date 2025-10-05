
public class FindPeakElement {
	// With Binary search template. 
	public int findPeak(int[] A) {
		int start = 1, end = A.length - 2;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] < A[mid + 1]) {
				start = mid;
			} else if (A[mid] < A[mid - 1]) {
				end = mid;
			} else {
				end = mid;
			}
		}
		if (A[start] < A[end]) {
			return end;
		}
		return start;
	}
    
    
    /* //TLE, might be dead loop.  
    public int findPeak(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        }
        
        int start = 1;
        int end = nums.length-2;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                    return mid;
            }
            
            if (nums[mid] > nums[mid-1]) {
                start = mid;
                continue;
            }
            
            if (nums[mid] > nums[mid+1] ) {
                end = mid;
            }
        }
        if (nums[start-1] < nums[start] && nums[start] > nums[start+1]) {
            return start;
        }
        if (nums[end-1] < nums[end] && nums[end] > nums[end+1]) {
            return end;
        }
        return -1;
    }
    */
}
