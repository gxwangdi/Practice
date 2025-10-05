/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    var total=0
    if (!height || height.length<3) {
        return total
    }
    var len=height.length
    var left=[]
    var right=[]

    var max=height[0]
    for (var i=1; i<height.length; i++) {
        left[i] = Math.max(max, height[i-1])
        max = Math.max(max, height[i])
    }

    max = height[len-1]
    for (var i=len-2; i>=0; i--) {
        right[i] = Math.max(max, height[i+1])
        max = Math.max(max, height[i])
    }

    var sum=0
    for(var i=1; i<len-1; i++) {
        sum = Math.min(left[i], right[i]) - height[i]
        if (sum>0) {
            total += sum
        }
    }
    return total
};
