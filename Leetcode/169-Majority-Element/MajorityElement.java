public class MajorityElement {
    
    public int majorityElement(int[] nums) {
        int number = 0;
        if (nums == null || nums.length == 0) {
            return number;
        }
        int count = 0;
        for (int i : nums) {
            if (i == number) {
                count++;
            } else {
                if (count == 0) {
                    number = i;
                } else {
                    count--;
                }
            }
        }
        return number;
    }
}



