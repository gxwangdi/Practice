/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    var res = 0
    if (!s || s.length == 0) {
        return res;
    }
    
    var flag = new Array(256).fill(false)
    var start = 0
    var len = s.length
    var i
    for (i=0; i<len; i++) {
        var cur = s.charAt(i)
        var curIdx = cur.charCodeAt(0)
        if (!flag[curIdx]) {
            flag[curIdx] = true
            continue
        }
        res = Math.max(res, i-start)
        var j
        for (j=start; j<i; j++) {
            var curj = s.charAt(j)
            var curIdx = curj.charCodeAt(0)
            if (curj == cur) {
                start = j+1
                break;
            }
            flag[curIdx] = false
        }
    }
    res = Math.max(res, len - start)
    return res
};

