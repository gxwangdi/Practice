/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    if (p.length == 0) {
        return s.length == 0;
    }
    
    if (p.length == 1 || p.charAt(1)!='*') {
        if (s.length == 0 || (p.charAt(0)!='.' && p.charAt(0)!= s.charAt(0))) {
            return false;
        } else {
            return isMatch(s.substr(1), p.substr(1));
        }
    }
    
    while (s.length > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0)=='.')) {
        if (isMatch(s, p.substr(2))) {
            return true;
        }
        s = s.substr(1);
    }
    
    return isMatch(s, p.substr(2))
};

