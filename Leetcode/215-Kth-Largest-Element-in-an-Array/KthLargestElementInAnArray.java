public class KthLargestElementInAnArray {
    
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k<=0) {
            return 0;
        }
        //Pay attention to the position, the kth largest in an ascending array is at position len-k+1
        return helper(nums, 0, nums.length-1, nums.length-k+1); 
    }
    
    private int helper(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        
        int position = partition(nums, l, r);
        if (position+1 == k) { // Pay attention to index and kth element.
            return nums[position];
        } else if (position+1 < k) {
            return helper(nums, position+1, r, k); // Always absolut position to avoid a lot of issues!
        } else {
            return helper(nums, l, position-1, k);
        }
    }// end of helper
    
    private int partition(int[] nums, int start, int end) {
        int left = start;
        int right = end;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right]>=pivot) {
                right--;
            }
            nums[left] = nums[right];// pivot is persisted, pay attention to how it reduces implementation complexity. 
            while (left < right && nums[left]<pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        
        nums[left] = pivot;
        return left;
    }
    
    
    /*
    // My implementation finds from tail to head, easy to get confused of kth element. 
    // For now it does not work. 
    public int findKthLargest(int[] nums, int k) {
        if (k<=0 || nums == null || nums.length <k) {
            return Integer.MIN_VALUE;
        }
        int index = findKthLargest(nums, 0, nums.length-1, k);
        return nums[index];
    }
    
    private int findKthLargest(int[] nums, int start, int end, int k) {
        if (start == end) {
            return start;
        }
        int mid = start + (end-start)/2;
        int target = nums[mid];
        int i = start;
        int j = end;
        while (i<j) {
            while (i<j && nums[i]<=target) {
                i++;
            }
            while (i<j && nums[j]>target) {
                j--;
            }
            if (i == j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        i--;
        j++;
        if (nums.length-j+1 > k) {
            return findKthLargest(nums, j, end, k);
        } else if (nums.length-j+1 < k) {
            return findKthLargest(nums, start, j-1, k - (end-j+1));
        } else {
            return j;
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    */
}




