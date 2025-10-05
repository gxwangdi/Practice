/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    var res = 0
    var an = 0
    for (var i=0; i<s.length; i++) {
        if (s.charAt(i) == ' ') {
            if (res!=0) {
                an=res
            }
            res=0
        } else {
            res++
        }
    }
    if (res!=0) {
        return res
    }
    return an
};
