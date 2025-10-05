import (
	"math"
)

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	size := len(nums1) + len(nums2)
	if size%2 == 1 {
		return float64(findkth(nums1, 0, nums2, 0, size/2+1))
	}
	return float64(findkth(nums1, 0, nums2, 0, size/2)+findkth(nums1, 0, nums2, 0, size/2+1)) / 2
}

func findkth(nums1 []int, start1 int, nums2 []int, start2 int, k int) int {
	if start1 >= len(nums1) {
		return nums2[start2+k-1]
	}
	if start2 >= len(nums2) {
		return nums1[start1+k-1]
	}
	if k == 1 {
		return min(nums1[start1], nums2[start2])
	}
	key1 := math.MaxInt64
	if start1+k/2-1 < len(nums1) {
		key1 = nums1[start1+k/2-1]
	}
	key2 := math.MaxInt64
	if start2+k/2-1 < len(nums2) {
		key2 = nums2[start2+k/2-1]
	}
	if key1 < key2 {
		return findkth(nums1, start1+k/2, nums2, start2, k-k/2)
	}
	return findkth(nums1, start1, nums2, start2+k/2, k-k/2)
}

func min(a int, b int) int {
	if a > b {
		return b
	}
	return a
}
