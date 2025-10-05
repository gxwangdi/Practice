/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    var s = x.toString()
    var i = 0
    var j = s.length-1
    while (i<j) {
        if (s.charAt(i)!=s.charAt(j)) {
            return false
        }
        i++
        j--
    }
    return true
};
