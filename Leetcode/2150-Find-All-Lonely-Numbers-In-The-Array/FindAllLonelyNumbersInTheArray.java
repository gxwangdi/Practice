

class FindAllLonelyNumbersInTheArray {
    public List<Integer> findLonely(int[] nums) {
        Set<Integer> ban = new HashSet<>();
        Set<Integer> pending = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (ban.contains(num)) { // not lonely
                pending.remove(num-1);
                pending.remove(num);
                pending.remove(num+1);
            } else {    // lonely
                pending.add(num);
            }
            ban.add(num-1);
            ban.add(num);
            ban.add(num+1);
        }
        return new ArrayList(pending);
    }
}
