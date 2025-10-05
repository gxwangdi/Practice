import java.util.ArrayList;
import java.util.List;

public class FindKPairsWithSmallestSums {
    
    // This shows a way to keep track of the index in an easy/straightforward way. 
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<int[]>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return ret;
        }
        
        int[] index = new int[nums1.length];
        while (k-- > 0) {
            int min_val = Integer.MAX_VALUE;
            int in = -1;
            for (int i = 0; i < nums1.length; i++) {
                if (index[i] >= nums2.length) {
                    continue;
                }
                if (nums1[i] + nums2[index[i]] < min_val) {
                    min_val = nums1[i] + nums2[index[i]];
                    in = i;
                }
            }
            if (in == -1) {
                break;
            }
            int[] temp = {nums1[in], nums2[index[in]]};
            ret.add(temp);
            index[in]++;
        }
        return ret;
    }
    
    /*
    // Priority queue approach.  Time O(klogk)   Space O(m).  
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>(k);
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k<=0) {
            return res;
        }
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[0]+a[1]-b[0]-b[1] );   
        for (int i=0; i<nums1.length && i<k; i++) {
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- >0 && !queue.isEmpty()) {
            int[] cur = queue.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length-1) {
                continue;
            }
            queue.offer(new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }
    */
    
    
    
    
    
    /*
    // My implementation does not handle duplicate elements for now. 
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || k<=0) {
            return res;
        } 
        
        if (nums1.length * nums2.length <=k) {
            return bruteForce(nums1, nums2);
        }
        
        int i=0;
        int j=0;
        while ( i<nums1.length-1 && j<nums2.length-1 ) {
            res.add(getPair(nums1, i, nums2, j));
            if (res.size() == k) {
                break;
            }
            if (nums1[i+1] + nums2[j] > nums1[i] + nums2[j+1]) {
                j++;
            } else {
                i++;
            }
        }
        if (res.size() == k) {
            return res;
        }
        if (i == nums1.length-1) {
            while (res.size()<k) {
                res.add(getPair(nums1, i, nums2, j));
                j++;
            }
        } else {
            while (res.size()<k) {
                res.add(getPair(nums1, i, nums2, j));
                i++;
            }
        }
        return res;
    }// end of kSmallestPairs    
    
    private int[] getPair(int[] arr1, int i, int[] arr2, int j) {
        int[] pair = new int[2];
        pair[0] = arr1[i];
        pair[1] = arr2[j];
        return pair;
    }
    
    private List<int[]> bruteForce(int[] arr1, int[] arr2) {
        List<int[]> res = new ArrayList<>(arr1.length*arr2.length);
        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr2.length; j++) {
                res.add(getPair(arr1, i, arr2, j));
            }
        }
        return res;
    }
    */
}





