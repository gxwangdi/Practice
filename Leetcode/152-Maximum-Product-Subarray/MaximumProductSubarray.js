/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    if (!nums && nums.length==0) {
        return 0
    }
    var maxProduct = nums[0]
    var maxTemp = nums[0]
    var minTemp = nums[0]

    for (var i=1; i<nums.length; i++) {
        var a = maxTemp*nums[i]
        var b = minTemp*nums[i]
        maxTemp = Math.max(Math.max(a,b), nums[i])
        minTemp = Math.min(Math.min(a,b), nums[i])
        maxProduct = Math.max(maxProduct, maxTemp)
    }
    return maxProduct
};
