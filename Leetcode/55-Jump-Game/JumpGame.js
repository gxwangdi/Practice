/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    if (!nums || nums.length == 0) {
        return false
    }
    var dp = new Array(nums.length).fill(false)
    dp[0] = true
    var cur = 0
    for (i=0; i<nums.length; i++) {
        if (!dp[i]) {
            return false
        }
        var far = i+nums[i]
        if (far >= nums.length-1) {
            return true
        }
        if (far < cur) {
            continue
        }
        while (cur <= far) {
            dp[cur] = true
            cur ++
        }
    }
    return dp[nums.length-1]
};
