import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1==null || nums2==null || nums1.length ==0 || nums2.length ==0) {
            return new int[0];
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i =0;
        int j =0;
        int last = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] == nums2[j] && nums1[i]!=last) {
                list.add(nums1[i]);
                last = nums1[i];
                i++;
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int cur =0; cur<res.length; cur++) {
            res[cur] = list.get(cur);
        }
        return res;
    }
    
    /*
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1==null || nums2==null || nums1.length ==0 || nums2.length ==0)
            return new int[0];
            
        int[] big;
        int[] small;
        if (nums1.length > nums2.length) {
            big = nums1;
            small = nums2;
        } else {
            big = nums2;
            small = nums1;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i:small) {
            set.add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i:big) {
            if (set.contains(i)) {
                result.add(i);
                set.remove(i);
            }
        }
        int[] reslist = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            reslist[i] = result.get(i);
        }
        
        return reslist;
    }// end 
    */
}


