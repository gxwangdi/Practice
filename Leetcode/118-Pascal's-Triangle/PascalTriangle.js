/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    if (numRows<1) {
        return []
    }
    var result = []
    for (var row=0; row < numRows; row++) {
        var arr = []
        arr[0] = arr[row] = 1
        for (var j=1; j<row; j++) {
            arr[j] = result[row-1][j]+result[row-1][j-1]
        }
        result[row] = arr
    }
    return result
};
