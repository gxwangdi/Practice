/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    if (!nums || nums.length<2) {
        return
    }
    var slow=0
    var fast=0
    while (fast<nums.length) {
        if (nums[fast]==0) {
            fast+=1
            continue
        }
        nums[slow]=nums[fast]
        slow+=1
        fast+=1
    }
    while (slow < nums.length) {
        nums[slow]=0
        slow+=1
    }
};
