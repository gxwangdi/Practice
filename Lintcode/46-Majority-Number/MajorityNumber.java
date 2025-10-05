import java.util.ArrayList;


public class MajorityNumber {
	/**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    
    public int majorityNumber(ArrayList<Integer> nums) {
        int res = 0;
        if (nums == null || nums.size() == 0) {
            return res;
        }
        int count = 0;
        for (Integer i : nums) {
            if (res == i) {
                count++;
            } else {
                if (count == 0) {
                    res = i;
                } else {
                    count--;
                }
            }
        }
        return res;
    }
    
    /*
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return Integer.MIN_VALUE;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                int frequency = map.get(i);
                frequency++;
                if (frequency >= nums.size()/2) {
                    return i;
                }
                map.put(i, frequency);
            } else {
                map.put(i, 1);
                if (1>=nums.size()/2) {
                    return i;
                }
            }
        }
        return Integer.MIN_VALUE;
    }
    */
}
