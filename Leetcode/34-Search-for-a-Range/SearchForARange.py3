class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        res = [-1,-1]
        if nums == None or len(nums) == 0:
            return res
        res[0] = self.binarySearch(nums, target, True)
        if res[0] == -1:
            return res
        res[1] = self.binarySearch(nums, target, False)
        return res

    def binarySearch(self, nums: List[int], target: int, isLowerBound: bool) -> int :
        left = 0
        right = len(nums)-1
        while left+1<right :
            mid = left + (right-left)//2
            if nums[mid] == target:
                if isLowerBound:
                    right = mid
                else:
                    left = mid
                continue
            if nums[mid] < target:
                left = mid
                continue
            if nums[mid] > target:
                right = mid
        res = -1
        if isLowerBound :
            if nums[left] == target:
                res = left
            elif nums[right] == target:
                res = right
        else :
            if nums[right] == target:
                res = right
            elif nums[left] == target:
                res = left
        return res
