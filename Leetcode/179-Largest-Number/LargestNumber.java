import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    
    private Comparator<String> numberComparator = new Comparator<String>(){
        public int compare(String s1, String s2) {
            return (s2+s1).compareTo(s1+s2);
        }
    };
    
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] stubs = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            stubs[i] = nums[i] + "";
        }
        Arrays.sort(stubs, numberComparator);
        int cur = 0;
        while (cur<nums.length && "0".equals(stubs[cur])) {
            cur++;
        }
        StringBuilder sb = new StringBuilder();
        while (cur < nums.length) {
            sb.append(stubs[cur]);
            cur++;
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }
}




