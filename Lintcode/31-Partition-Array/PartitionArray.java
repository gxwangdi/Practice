
public class PartitionArray {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
	public int partitionArray(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int j = nums.length - 1;
		for (int i = 0; i <= j; i++) {
			if (nums[i] < k) {
				continue;
			}
			while (j >= i && nums[j] >= k) {
				j--;
			}
			if (j >= 0 && i < j) {
				swap(nums, i, j);
				j--;
			}
		}
		return j + 1;
	}
    
    /*
    public int partitionArray(int[] nums, int k) {
	    
	    if (nums == null || nums.length==0) {
	        return 0;
	    }
	    
	    int left = 0;
	    int right = nums.length-1;
	    int res = nums.length-1;
	    while (left < right) {
	        while (left < right && nums[right] >=k) {
	            right--;
	        }
	        while (left < right && nums[left] < k ) {
	            left++;
	        }
	        if (left == right) {
	            continue;
	        }
	        swap(nums, left, right);
	        left++;
	        right--;
	    }
	    if (nums[right] >= k) {
	        return right;
	    }
	    return right+1;
    }
    */
    
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
