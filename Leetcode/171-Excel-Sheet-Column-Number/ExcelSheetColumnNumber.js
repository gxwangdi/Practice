/**
 * @param {string} s
 * @return {number}
 */
var titleToNumber = function(s) {
    if (!s) {
        return -1
    }
    let len = s.length
    if (len<1) {
        return 0
    }
    var total = 0;
    var i;
    for (i=0; i<len; i++) {
        total *= 26
        total += s[i].charCodeAt(0) - 'A'.charCodeAt(0) +1
    }
    return total
};
