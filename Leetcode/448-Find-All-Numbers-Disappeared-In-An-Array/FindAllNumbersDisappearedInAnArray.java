
class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],true);
        }

        for ( int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
