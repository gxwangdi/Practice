class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        if numbers == None or len(numbers) == 0:
            return [-1,-1]
        left = 0
        length = len(numbers)
        right = length-1
        while left < right:
            temp = numbers[left] + numbers[right]
            if temp == target:
                return [left+1, right+1]
            elif temp < target:
                left+=1
            else:
                right-=1
        return [-1, -1]
    
