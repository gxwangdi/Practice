import java.util.ArrayList;
import java.util.List;

public class SingleNumberIII {
    
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length <2) {
            return null;
        }
        int[] res = new int[2];
        int mix = 0;
        for (int i : nums) {
            mix = mix^i;
        }
        int count = -1;
        int o = 0;
        while (o == 0) {
            count++;
            o = (mix>>count)&1;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i : nums) {
            if (((i>>count)&1) == 1) {
                list1.add(i);
            } else {
                list2.add(i);
            }
        }
        mix = 0;
        for (int i : list1) {
            mix = mix^i;
        }
        res[0] = mix;
        mix = 0;
        for (int i : list2) {
            mix = mix^i;
        }
        res[1] = mix;
        return res;
    }
}




