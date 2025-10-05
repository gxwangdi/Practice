/**
 * @param {number[]} A
 * @return {number}
 */
var maxRotateFunction = function(A) {
    var F = 0
    var sum = 0
    var n = A.length
    if (n<=1) {
        return 0
    }
    for (var i=0; i<n; i++) {
        F += i*A[i]
        sum += A[i]
    }
    var res = F
    for (var k=1; k<n; k++) {
        F+= sum
        F -= n*A[n-k]
        if (F>res) {
            res = F
        }
    }
    return res
};
