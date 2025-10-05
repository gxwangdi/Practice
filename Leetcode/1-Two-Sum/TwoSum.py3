class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict = {}
        for index, val in enumerate(nums) :
            key = target - val
            if (key in list(dict.keys())) :
                res = [dict[key], index]
                return res
            dict[val] = index
        return None
        
