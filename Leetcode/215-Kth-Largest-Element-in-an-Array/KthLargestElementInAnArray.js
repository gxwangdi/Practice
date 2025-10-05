/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
    if (!nums || nums.length == 0 || k<=0) {
        return 0
    }

    var helper = function(nums, left, right, k) {
        if (left == right) {
            return nums[left]
        }
        var partition = function(nums, left, right) {
            var pivot = nums[left]
            while (left < right) {
                while (left < right && nums[right]>=pivot) {
                    right--
                }
                nums[left] = nums[right]
                while (left < right && nums[left]<pivot) {
                    left++
                }
                nums[right] = nums[left]
            }
            nums[left] = pivot
            return left
        };
        var pos = partition(nums, left, right)
        if (pos+1 == k) {
            return nums[pos]
        } else if (pos+1 < k) {
            return helper(nums, pos+1, right, k)
        } else {
            return helper(nums, left, pos-1, k)
        }

    };
    return helper(nums, 0, nums.length-1, nums.length-k+1)
};
