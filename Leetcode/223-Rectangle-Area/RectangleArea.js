/**
 * @param {number} A
 * @param {number} B
 * @param {number} C
 * @param {number} D
 * @param {number} E
 * @param {number} F
 * @param {number} G
 * @param {number} H
 * @return {number}
 */
var computeArea = function(A, B, C, D, E, F, G, H) {
    if (A>G || E>C) {
        return (C-A)*(D-B) + (G-E)*(H-F)
    }
    if (F>D || B>H) {
        return (C-A)*(D-B) + (G-E)*(H-F)
    }
    var right = Math.min(C,G)
    var left = Math.max(A,E)
    var top = Math.min(H,D)
    var bottom = Math.max(F,B)

    return (G-E)*(H-F) + ((C-A)*(D-B) - (right-left)*(top-bottom))
};
