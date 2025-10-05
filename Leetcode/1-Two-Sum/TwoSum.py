# This is for python 2.
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {}
        for index, val in enumerate(nums) :
            key = target - val;
            if (dict.has_key(key)) :
                list = [dict[key], index]
                return list
            dict[val] = index
        return None
