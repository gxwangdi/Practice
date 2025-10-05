import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        int[] big;
        int[] small;
        if (nums1.length>nums2.length) {
            big = nums1;
            small = nums2;
        } else {
            big = nums2;
            small = nums1;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: small) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }// end of small loop
        
        List<Integer> result = new ArrayList<>();
        for (int i: big) {
            if (map.containsKey(i)) {
                result.add(i);
                int fre = map.get(i);
                if (fre == 1) {
                    map.remove(i);
                } else {
                    map.put(i, fre-1);
                }
            }
        }// end of big loop
        int[] resList = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            resList[i] = result.get(i);
        }
        return resList;
    }
}