/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    if (n<0) {
        return 0
    }
    if (n<3) {
        return n
    }
    var dp = [1,2]
    var i = 2
    while (i<n) {
        dp[i%2] = dp[(i-1)%2] + dp[(i-2)%2];
        i++
    }
    return dp[(n-1)%2]
};

