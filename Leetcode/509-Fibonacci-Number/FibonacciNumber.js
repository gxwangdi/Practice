/**
 * @param {number} N
 * @return {number}
 */
var fib = function(N) {
    if (N<0) {
        return -1
    }
    if (N<2) {
        return N
    }
    var dp = [0,1]
    for(i=2; i<=N; i++) {
        dp[i%2] = dp[(i-1)%2] + dp[(i-2)%2]
    }
    return dp[N%2]
};
