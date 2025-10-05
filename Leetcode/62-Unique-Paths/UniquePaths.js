/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    if (m<=0 || n<=0) {
        return 0
    }
    var N=n+m-2
    var k=m-1
    var res = 1.0
    for (var i=1; i<=k; i++) {
        res = res * (N - k + i) / i
    }
    return ~~res
};
