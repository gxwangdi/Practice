/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {
    if (ransomNote.length > magazine.length) {
        return false
    }
    var count = {}
    for (var i=0; i<magazine.length; i++) {
        var letter = magazine[i]
        count[letter] = count[letter]||0
        count[letter]++
    }
    for (var i=0; i<ransomNote.length; i++) {
        var letter = ransomNote[i]
        if (!count[letter]) {
            return false
        }
        count[letter]--
    }
    return true
};
