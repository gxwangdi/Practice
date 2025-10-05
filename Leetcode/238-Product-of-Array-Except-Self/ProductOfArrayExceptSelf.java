public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] res = new int[nums.length];
        int p =1;
        res[0] = 1;
        for (int i=1; i<nums.length; i++) {
            p *= nums[i-1];
            res[i] = p;
        }

        p=1;
        for (int i=nums.length-2; i>=0; i--) {
            p *= nums[i+1];
            res[i] *= p;
        }
        return res;
    }
    /* // Space O(n)   Time O(n)
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        long[] f = new long[nums.length];
        long[] b = new long[nums.length];
        int[] res = new int[nums.length];
        f[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            f[i] = f[i-1] * nums[i];
        }
        b[nums.length-1] = nums[nums.length-1];
        for (int i=nums.length-2; i>=0; i--) {
            b[i] = b[i+1] * nums[i];
        }
        res[0] = (int)b[1];
        res[nums.length-1] = (int)f[nums.length-2];
        for (int i=1; i<nums.length-1; i++) {
            res[i] = (int)(f[i-1] * b[i+1]);
        }
        return res;
    }*/

    /* // This is from discussion, very elegant recursive implementation, but get a StackOverflowError
    public int[] productExceptSelf(int[] nums) {
        multiply(nums, 0, 1, nums.length);

        return nums;
    }

    private int multiply(int[] a, int index, int fwdProduct, int length) {
        int recProduct =1;
        if (index >= length) {
            return recProduct;
        }
        recProduct = multiply(a, index+1, fwdProduct*a[index], length);
        int cur = a[index];
        a[index] = recProduct * fwdProduct;
        recProduct *= cur;

        return recProduct;
    }*/
}
