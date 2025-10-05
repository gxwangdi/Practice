/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    if (!numbers || numbers.length <2) {
        return [-1,-1]
    }
    var left=0
    var right=numbers.length-1
    while (left<right) {
        var s = numbers[left] + numbers[right]
        if (s == target) {
            return [left+1, right+1]
        } else if (s > target) {
            right--
        } else {
            left++
        }
    }
    return [-1,-1]
};


