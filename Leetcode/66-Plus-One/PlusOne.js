/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    if (!digits || digits.length == 0) {
        return digits
    }
    if (digits[digits.length-1]<9) {
        digits[digits.length-1]++
        return digits
    }
    var i=digits.length-1
    while (i>=0) {
        if (digits[i]==9) {
            digits[i]=0
            i--
        } else {
            digits[i]++
            break
        }
    }
    if (i==-1) {
        digits.splice(0, 0, 1)
    }
    return digits
};
