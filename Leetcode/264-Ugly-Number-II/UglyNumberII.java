import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        // Write your code here
        if (n <= 0) {
            return 0;
        }
        List<Integer> res = new ArrayList<>(n);
        res.add(1);
        int cur = 2;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while (res.size() < n) {
            while (res.get(index2)*2 < cur) {
                index2++;
            }
            int res2 = res.get(index2)*2;
            while (res.get(index3)*3 < cur) {
                index3++;
            }
            int res3 = res.get(index3)*3;
            while (res.get(index5)*5 < cur) {
                index5++;
            }
            int res5 = res.get(index5)*5;
            
            int min = Math.min(Math.min(res2, res3), res5);
            cur = min+1;
            res.add(min);
        }
        return res.get(n-1);
    }
    
    /*
    public int nthUglyNumber(int n) {
        if (n <=0) {
            return 0;
        }
        Queue<Integer> q = new PriorityQueue<>();
        q.offer(1);
        for (int i=0; i<n-1; i++) {
            int cur = q.poll();
            // System.out.println(cur);
            q.offer(cur*2);
            q.offer(cur*3);
            q.offer(cur*5);
        }
        return q.poll();
    }// end of nthUglyNumber   
    */
    
    /*
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] =1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        for (int i=1; i<n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min) {
                factor2 = 2*ugly[++index2];
            } else if (factor3 == min) {
                factor3 = 3*ugly[++index3];
            } else if (factor5 == min) {
                factor5 = 5*ugly[++index5];
            }
        }
        return ugly[n-1];
    }
    */
}






