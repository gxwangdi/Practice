/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    if (!nums || nums.length<2) {
        return
    }
    var cur=0
    var left=0
    var right=nums.length-1
    while (left<nums.length) {
        while (left<nums.length && nums[left]==cur) {
            left++
        }
        while (right>=0 && nums[right]!=cur) {
            right--
        }
        if (left<right) {
            swap(nums, left, right)
            left++
            right--
        } else {
            right = nums.length-1
            cur++
        }
    }
};

var swap = function(nums, i, j) {
    var temp= nums[i]
    nums[i] = nums[j]
    nums[j] = temp
};
