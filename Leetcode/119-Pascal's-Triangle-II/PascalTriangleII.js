/**
 * @param {number} rowIndex
 * @return {number[]}
 */
var getRow = function(rowIndex) {
    if (rowIndex<0) {
        return []
    }
    if (rowIndex==0) {
        return [1]
    }
    var cur = [1,1]
    if (rowIndex==1) {
        return cur
    }
    for (var k=2; k<=rowIndex; k++) {
        var next = []
        for (var i=0; i<=k; i++) {
            if (i==0 || i==k) {
                next.push(1)
                continue
            }
            next.push(cur[i-1] + cur[i])
        }
        cur = next
    }
    return cur
};
