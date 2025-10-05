/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function(s) {
    return valid(s, 0, s.length-1, 0)
};

var valid = function(s, left, right, times) {
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            if (times<1) {
                return valid(s, left+1, right, times+1) || valid(s, left, right-1, times+1)
            } else {
                return false
            }
        }
        left++
        right--
    }
    return true
}


