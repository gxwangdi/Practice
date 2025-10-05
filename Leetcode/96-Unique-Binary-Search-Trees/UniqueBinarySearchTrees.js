/**
 * @param {number} n
 * @return {number}
 */
var numTrees = function(n) {
    if (n<0) {
        return 0
    }
    if (n==0) {
        return 1
    }
    var dp = new Array(n+1)
    dp[0]=1
    dp[1]=1
    for (var i=2; i<=n; i++) {
        dp[i] = 0 // otherwise it is undefined
        for (var j=0; j<i; j++) {
            dp[i] += dp[j]*dp[i-j-1]
        }
    }
    return dp[n]
};
