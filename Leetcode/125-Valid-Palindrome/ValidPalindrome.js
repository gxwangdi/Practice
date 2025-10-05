/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    if (!s) {
        return true
    }
    s = s.toLowerCase()
    s = s.trim()
    s = s.replace(/[^a-z0-9]/g, "")
    if (s.length<2) {
        return true
    }
    var left = 0
    var right = s.length -1
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false
        }
        left++
        right--
    }
    return true
};


