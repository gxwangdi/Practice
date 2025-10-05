
class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        if (nums == null || nums.length <1) {
            return nums;
        }
        int[] res = new int[nums.length*2];
        System.arraycopy(nums, 0, res, 0, nums.length);
        System.arraycopy(nums, 0, res, nums.length, nums.length);
        return res;
    }
}
