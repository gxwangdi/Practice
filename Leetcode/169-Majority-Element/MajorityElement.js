/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    var res=0
    var count=0
    var num
    for (num in nums) {
        if (count==0) {
            res = nums[num]
            count++
        } else {
            if (nums[num]==res) {
                count++
            } else {
                count--
            }
        }
    }
    return res
};

