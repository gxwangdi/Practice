

class Splitarraylargestsum {
    private int minimumSubarraysRequired(int[] nums, int maxSumAllowed) {
        int currentSum = 0;
        int splitsRequired = 0;

        for (int element : nums) {
            // Add element only if the sum doesn't exceed maxSumAllowed
            if (currentSum + element <= maxSumAllowed) {
                currentSum += element;
            } else {
                // If the element addition makes sum more than maxSumAllowed
                // Increment the splits required and reset sum
                currentSum = element;
                splitsRequired++;
            }
        }

        // Return the number of subarrays, which is the number of splits + 1
        return splitsRequired + 1;
    }

    public int splitArray(int[] nums, int m) {
        // Find the sum of all elements and the maximum element
        int sum = 0;
        int maxElement = Integer.MIN_VALUE;
        for (int element : nums) {
            sum += element;
            maxElement = Math.max(maxElement, element);
        }

        // Define the left and right boundary of binary search
        int left = maxElement;
        int right = sum;
        int minimumLargestSplitSum = 0;
        while (left <= right) {
            // Find the mid value
            int maxSumAllowed = left + (right - left) / 2;

            // Find the minimum splits. If splitsRequired is less than
            // or equal to m move towards left i.e., smaller values
            if (minimumSubarraysRequired(nums, maxSumAllowed) <= m) {
                right = maxSumAllowed - 1;
                minimumLargestSplitSum = maxSumAllowed;
            } else {
                // Move towards right if splitsRequired is more than m
                left = maxSumAllowed + 1;
            }
        }

        return minimumLargestSplitSum;
    }

//     int[] nums;
//     public int splitArray(int[] nums, int m) {
//         this.nums = nums;
//         int low = 0, high = 0, min = Integer.MAX_VALUE;
//         for(int i=0;i<nums.length;i++){
//             low = Math.max(low, nums[i]);
//             high += nums[i];
//         }
//         while(low <= high) {
//             int mid = (low + high) / 2;
//             if(required_no_of_chunks(mid, m)){
//                min = Math.min(min, mid);
//                high = mid - 1;
//             }
//             else low = mid + 1;
//         }
//         return min;
//     }

//     private boolean required_no_of_chunks(int mid, int m){
//         int chunks = 0, i=0;
//         while(i < nums.length){
//             int val = 0;
//             while(i < nums.length && nums[i] + val <= mid) val += nums[i++];
//             chunks++;
//         }
//         return chunks <= m;
//     }
}
