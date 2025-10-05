/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    if (!matrix || matrix.length == 0 || matrix[0].length == 0) {
        return false
    }
    var i=0
    var j=matrix[0].length-1
    while(i<matrix.length && j>=0) {
        var temp = matrix[i][j]
        if (temp == target) {
            return true
        }
        if (temp > target) {
            j--
        } else {
            i++
        }
    }
    return false
};
