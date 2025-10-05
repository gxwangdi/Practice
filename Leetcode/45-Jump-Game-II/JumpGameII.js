/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    if (!nums || nums.length == 0) {
        return -1
    }
    if (nums.length == 1) {
        return 0
    }
    var dp = new Array(nums.length).fill(Number.MAX_VALUE)
    dp[0] = 0
    var cur = 1
    for (i=0; i<nums.length; i++) {
        var far = i+nums[i]
        var value = dp[i] + 1
        if (far >= nums.length-1) {
            return value
        }
        if (far < cur) {
            continue
        }
        while (cur <= far) {
            dp[cur] = value
            cur +=1
        }
    }
    return dp[nums.length-1]
};
