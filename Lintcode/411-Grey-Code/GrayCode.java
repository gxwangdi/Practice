import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class GrayCode {
	/**
     * @param n a number
     * @return Gray code
     */
    // Solution 4
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.empty()) {
            int t = stack.pop();
            for (int i=0; i<n; i++) {
                int k = t;
                if ((k & (1 << i)) == 0) {
                    k |= (1 << i);
                } else {
                    k &= ~(1 << i);
                }
                if (set.contains(k)) {
                    continue;
                }
                set.add(k);
                stack.push(k);
                res.add(k);
                break;
            }
        }
        return res;
    }
    
    // Solution 3
    // public List<Integer> grayCode(int n) {
    //     List<Integer> result = new ArrayList<>();
    //     result.add(0);
    //     long len = (long)Math.pow(2, n);
    //     for (int i=1; i<len; i++) {
    //         int pre = result.get(result.size()-1);
    //         if (i%2 == 1) {
    //             pre = (int)((pre & (len - 2)) | (~pre & 1));
    //         } else {
    //             int count = 1;
    //             int t = pre;
    //             while ((t&1)!=1) {
    //                 count++;
    //                 t>>=1;
    //             }
    //             if ((pre & (1 << count)) == 0) {
    //                 pre |= (1 << count);
    //             } else {
    //                 pre &= ~(1 << count);
    //             }
    //         }
    //         result.add(pre);
    //     }
    //     return result;
    // }
    
    // Solution 2
    // public List<Integer> grayCode(int n) {
    //     List<Integer> result = new ArrayList<>();
    //     result.add(0);
    //     for (int i=0; i<n; i++) {
    //         int size = result.size();
    //         for (int j=size-1; j>=0; j--) {
    //             result.add(result.get(j) | (1<<i) );
    //         }
    //     }
    //     return result;
    // }
    
    // Solution 1
    // public List<Integer> grayCode(int n) {
    //     List<Integer> result = new ArrayList<>();
    //     for (int i=0; i<Math.pow(2,n); i++) {
    //         result.add((i>>1)^i);
    //     }
    //     return result;
    // }
}



