
class FindAllKDistantIndicesInAnArray {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return res;
        }
        List<Integer> index = getKeyIndex(nums, key);
        int minIndex = -1;
        for(int i : index) {
            for (int j =-k;j<=k; j++) {
                if (i+j<=minIndex) {
                    continue;
                }
                if (i+j>=nums.length) {
                    continue;
                }
                minIndex = i+j;
                res.add(minIndex);
            }
        }
        return res;
    }

    private List<Integer> getKeyIndex(int[] nums, int key) {
        List<Integer> res = new ArrayList<>();
        for(int i =0; i<nums.length; i++) {
            if (nums[i] == key) {
                res.add(i);
            }
        }
        return res;
    }
}
