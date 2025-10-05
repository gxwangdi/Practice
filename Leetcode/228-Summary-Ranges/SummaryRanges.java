import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length ==0) {
            return res;
        }
        
        int i=0;
        int j=1;
        while (j<nums.length) {
            if (nums[j] != nums[j-1]+1) {
                res.add(getString(nums[i], nums[j-1]));
                i = j;
            }
            j++;
        }
        // Pay attention to how i and j changes, and the exit state.
        res.add(getString(nums[i], nums[j-1]));
        return res;
    }
    
    private String getString(int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        if (i == j) {
            return sb.toString();
        }
        sb.append("->");
        sb.append(j);
        return sb.toString();
    }
}






