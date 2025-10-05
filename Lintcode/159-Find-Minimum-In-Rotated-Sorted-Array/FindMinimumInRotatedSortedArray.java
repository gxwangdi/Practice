
public class FindMinimumInRotatedSortedArray {
	/**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
	public int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return -1;
		}

		int left = 0;
		int right = num.length - 1;
		int target = num[right];

		// find the first one <= target
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (num[mid] >= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (num[left] <= target) {
			return num[left];
		} else {
			return num[right];
		}
	}
     /*
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return Integer.MIN_VALUE;
        }
        int left = 0;  
        int right = num.length -1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (num[left] < num[mid-1] && num[mid] < num[right]) {
                if (num[mid] < num[mid-1] && num[mid] < num[mid+1]) {
                    return num[mid];
                } else {
                    return num[left];
                }
            }
            if (num[left] > num[mid-1]) {
                right = mid -1;
            } 
            if (num[mid] > num[right]) {
                left = mid + 1;
            }
            if (left == mid-1) {
                break;
            }
        }
        return num[left];  
    }*/
}
