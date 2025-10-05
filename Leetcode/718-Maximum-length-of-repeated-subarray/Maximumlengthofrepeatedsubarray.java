

class Maximumlengthofrepeatedsubarray {
    // DP
    // public int findLength(int[] nums1, int[] nums2) {
    //     int res = 0;
    //     int[][] dp = new int[nums1.length+1][nums2.length+1];
    //     for(int i=nums1.length-1; i>=0; i--) {
    //         for(int j=nums2.length-1; j>=0; j--) {
    //             if (nums1[i] == nums2[j]) {
    //                 dp[i][j] = dp[i+1][j+1] +1;
    //                 res = Math.max(res, dp[i][j]);
    //             }
    //         }
    //     }
    //     return res;
    // }

    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        for(int i=0; i<nums1.length + nums2.length-1; i++) {
            // The current overlapping window is A[aStart, Math.min(A.length, B.length)] and B[bStart, Math.min(A.length, B.length)].
            int aStart = Math.max(0, nums1.length - 1 - i);
            int bStart = Math.max(0, i - (nums1.length - 1));
            int numConsecutiveMatches = 0;
            for (int aIdx = aStart, bIdx = bStart; aIdx < nums1.length && bIdx < nums2.length; ++aIdx, ++bIdx) {
            // Maintain number of equal consecutive elements in the current window (overlap) and the max number ever computed.
            numConsecutiveMatches = nums1[aIdx] == nums2[bIdx] ? numConsecutiveMatches + 1 : 0;
            res = Math.max(res, numConsecutiveMatches);
            }
        }
        return res;
    }
}
