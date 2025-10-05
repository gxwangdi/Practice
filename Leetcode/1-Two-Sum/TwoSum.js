/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var res = [];
    var map = {};
    for (var i = 0; i < nums.length; i++) {
        var key = target - nums[i];
        if (!map[key]) {
            res.push(map[key], i);
            return res;
        }
        map[nums[i]] = i;
    }
    return res;
};
