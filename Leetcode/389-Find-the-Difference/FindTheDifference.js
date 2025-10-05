/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
function findTheDifference(s, t) {
    let cur = t.charCodeAt(t.length-1);
    for(let i=0; i < s.length; i++){
        cur = cur ^ s.charCodeAt(i) ^ t.charCodeAt(i);
    }
    return String.fromCharCode(cur);
};
