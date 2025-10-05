/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    if (s.length <= numRows || numRows <2) {
        return s
    }

    var sb = ""
    let size = 2*numRows-2
    for (i=0; i<numRows; i++) {
        for (j=i; j<s.length; j+=size) {
            sb += s.charAt(j);
            if (i!=0 && i!=numRows-1) {
                var temp = j+size-2*i
                if (temp < s.length) {
                    sb+=s.charAt(temp)
                }
            }
        }
    }
    return sb
};
