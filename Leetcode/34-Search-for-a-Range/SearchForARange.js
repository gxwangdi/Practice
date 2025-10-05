/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    var res = [-1,-1]
    if (!nums || nums.length == 0) {
        return res
    }
    res[0] = binarySearch(nums, target, true)
    if (res[0] == -1) {
        return res
    }
    res[1] = binarySearch(nums, target, false)
    return res
};

var binarySearch = function(nums, target, isLowerBound) {
    var left = 0
    var right = nums.length -1
    var mid
    while (left+1<right) {
        mid = left + Math.floor((right-left)/2)
        if (nums[mid] == target) {
            if (isLowerBound) {
                right = mid
            } else {
                left = mid
            }
            continue
        }
        if (nums[mid] < target) {
            left = mid
            continue
        }
        if (nums[mid] > target) {
            right = mid
        }
    }
    var res =-1
    if (isLowerBound) {
        if (nums[left] == target) {
            res = left
        } else if (nums[right] == target) {
            res = right
        }
    } else {
        if (nums[right] == target) {
            res = right
        } else if (nums[left] == target) {
            res = left
        }
    }
    return res
};
