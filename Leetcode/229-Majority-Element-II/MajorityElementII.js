/**
 * @param {number[]} nums
 * @return {number[]}
 */
var majorityElement = function(nums) {
    var res = []
    if (!nums || nums.length == 0) {
        return res
    }
    if (nums.length < 3) {
        for (index in nums) {
            if (!res.includes(nums[index])) {
                res.push(nums[index])
            }
        }
        return res
    }
    var number1
    var number2
    var count1 = 0
    var count2 = 0
    for (index in nums) {
        if (number1 == nums[index]) {
            count1++
        } else if (number2 == nums[index]) {
            count2++
        } else if (count1 == 0) {
            number1 = nums[index]
            count1 = 1
        } else if (count2 == 0) {
            number2 = nums[index]
            count2 = 1
        } else {
            count1--
            count2--
        }
    }
    
    count1 = count2 = 0
    for (index in nums) {
        if (number1 == nums[index]) {
            count1++
        }
        if (number2 == nums[index]) {
            count2++
        }
    }
    if (count1 > nums.length/3) {
        res.push(number1)
    }
    if (count2 > nums.length/3) {
        res.push(number2)
    }
    return res
};


