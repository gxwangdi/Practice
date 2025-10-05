/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    var len = nums1.length + nums2.length
    if (len%2 == 1) {
        return findkth(nums1, 0, nums2, 0, Math.floor(len/2)+1)
    }
    return (findkth(nums1, 0, nums2, 0, Math.floor(len/2)) + findkth(nums1, 0, nums2, 0, Math.floor(len/2)+1))/2.0
};

var findkth = function(nums1, start1, nums2, start2, k) {
    if (start1 >= nums1.length) {
        return nums2[start2+k-1]
    }
    if (start2 >= nums2.length) {
        return nums1[start1+k-1]
    }
    if (k==1) {
        return Math.min(nums1[start1], nums2[start2])
    }

    var key1 = start1 + Math.floor(k/2) -1 < nums1.length? nums1[start1+Math.floor(k/2)-1] : Number.MAX_SAFE_INTEGER
    var key2 = start2 + Math.floor(k/2) -1 < nums2.length? nums2[start2+Math.floor(k/2)-1] : Number.MAX_SAFE_INTEGER

    if (key1 < key2) {
        return findkth(nums1, start1+Math.floor(k/2), nums2, start2, k-Math.floor(k/2))
    }
    return findkth(nums1, start1, nums2, start2+Math.floor(k/2), k-Math.floor(k/2))
};
