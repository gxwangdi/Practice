

class Squaresofasortedarray {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
//     public int[] sortedSquares(int[] nums) {
//         if (nums[0] > 0) {
//             for(int i=0; i<nums.length; i++) {
//                 nums[i] = nums[i]*nums[i];
//             }
//             return nums;
//         }
//         if (nums[nums.length-1] <0) {
//             int[] res = new int[nums.length];
//             int i=0;
//             int j=res.length-1;
//             while (i<nums.length) {
//                 res[j] = nums[i]*nums[i];
//                 i++;
//                 j--;
//             }
//             return res;
//         }

//     }
}
