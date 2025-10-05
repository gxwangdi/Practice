/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    var left = 0
    var right = x
    var t
    var mid
    while (left+1<right) {
        mid = left+Math.floor((right-left)/2)
        t = mid*mid
        if (t == x) {
            return mid
        }
        if (t<x) {
            left = mid
        } else {
            right = mid
        }
    }
    t = right*right
    if (t>x) {
        return left
    }
    return right
};
