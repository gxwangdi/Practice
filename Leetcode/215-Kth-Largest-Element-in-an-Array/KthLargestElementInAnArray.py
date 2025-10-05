class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if not nums or k<=0:
            return 0
        size = len(nums)
        return self._helper(nums, 0, size-1, size-k+1)

    def _helper(self, nums, left, right, k):
        """
        :type nums: List[int]
        :type left: int
        :type right: int
        :type k: int
        :rtype int
        """
        if left == right:
            return nums[left]
        pos = self._partition(nums, left, right)
        if pos+1 == k:
            return nums[pos]
        elif pos+1 < k:
            return self._helper(nums, pos+1, right, k)
        else:
            return self._helper(nums, left, pos-1, k)

    def _partition(self, nums, left, right):
        """
        :type nums: List[int]
        :type left: int
        :type right: int
        :rtype int
        """
        pivot = nums[left]
        while left < right:
            while left < right and nums[right]>=pivot:
                right-=1
            nums[left] = nums[right]
            while left < right and nums[left]<pivot:
                left+=1
            nums[right] = nums[left]

        nums[left] = pivot
        return left
    
