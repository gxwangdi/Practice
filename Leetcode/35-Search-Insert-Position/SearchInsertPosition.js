/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    if (!nums || nums.length == 0) {
        return 0
    }
    var start = 0
    var end = nums.length-1
    const getMidPoint = (start, end) => Math.floor((end - start) / 2) + start

    while (start < end) {
        var mid = getMidPoint(start, end)
        if (nums[mid]==target) {
            return mid
        }
        if (nums[mid]>target) {
            end = mid-1
        } else {
            start = mid+1
        }
    }
//     start == end
    if (nums[start] < target) {
        return start+1
    }
    return start
};
