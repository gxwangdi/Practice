class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        res = []
        number1 = number2 = 0
        count1 = count2 = 0
        n = len(nums)
        for num in nums :
            if num == number1:
                count1 += 1
            elif num == number2:
                count2 += 1
            elif count1 == 0:
                number1 = num
                count1 = 1
            elif count2 == 0:
                number2 = num
                count2 = 1
            else:
                count1-=1
                count2-=1
        count1 = count2 = 0
        for num in nums:
            if num == number1:
                count1 += 1
            elif num == number2:
                count2 += 1
        if count1 > n//3:
            res.append(number1)
        if count2 > n//3:
            res.append(number2)
        return res
    
    
