class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        size = len(nums1) + len(nums2)
        if size%2 == 1 :
            return self.findkth(nums1, 0, nums2, 0, size//2+1)

        return (self.findkth(nums1, 0, nums2, 0, size//2) + self.findkth(nums1, 0, nums2, 0, size//2+1))/2

    def findkth(self, nums1: List[int], start1: int, nums2: List[int], start2: int, k: int) -> int:
        if start1 >= len(nums1):
            return nums2[start2+k-1]
        if start2 >= len(nums2):
            return nums1[start1+k-1]
        if k==1 :
            return min(nums1[start1], nums2[start2])

        if start1 + k//2 -1 < len(nums1):
            key1 = nums1[start1+k//2-1]
        else:
            key1 = sys.maxsize

        if start2 + k//2 -1 < len(nums2):
            key2 = nums2[start2+k//2-1]
        else:
            key2 = sys.maxsize

        if key1 < key2 :
            return self.findkth(nums1, start1+k//2, nums2, start2, k-k//2)

        return self.findkth(nums1, start1, nums2, start2+k//2, k-k//2)
