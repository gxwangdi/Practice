/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    var left = 0
    var right = nums.length-1
    var target = nums[right]
    var mid
    while (left+1<right) {
        mid = left + Math.floor((right-left)/2)
        if (nums[mid]<= target) {
            right = mid
        } else {
            left = mid
        }
    }
    if (nums[left] <= target) {
        return nums[left]
    }
    return nums[right]
};
