class SubarraySumEqualsK {
    // public int subarraySum(int[] nums, int k) {
    //     if(nums.length<1){
    //         return 0;
    //     }
    //     Map<Integer,Integer> map = new HashMap<>();
    //     int c=0;
    //     int sum=0;
    //     for(int i=0;i<nums.length;i++){
    //         sum+=nums[i];
    //         if(sum==k){
    //             c++;
    //         }
    //         if(map.containsKey(sum-k)){
    //             c+=map.get(sum-k);
    //         }
    //         map.put(sum,map.getOrDefault(sum,0)+1);
    //     }
    //     return c;
    // }

    // 06/2022
    // public int subarraySum(int[] nums, int k) {
    //     int count = 0;
    //     int[] sum = new int[nums.length + 1];
    //     sum[0] = 0;
    //     for (int i = 1; i <= nums.length; i++)
    //         sum[i] = sum[i - 1] + nums[i - 1];
    //     for (int start = 0; start < nums.length; start++) {
    //         for (int end = start + 1; end <= nums.length; end++) {
    //             if (sum[end] - sum[start] == k)
    //                 count++;
    //         }
    //     }
    //     return count;
    // }

    public int subarraySum(int[] nums, int k) {
        var count =0;
        var sum = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for(int i: nums) {
            sum += i;
            if (map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
