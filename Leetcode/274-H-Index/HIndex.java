public class HIndex {
    
    // O(n)
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int len = citations.length;
        int[] count = new int[len+1];
        for (int i=0; i<len; i++) {
            if (citations[i] > len) {
                count[len]++;
            } else {
                count[citations[i]]++;
            }
        }
        int t = 0;
        int res = 0;
        for (int i=len; i>=0; i--) {
            t += count[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }
    
    /*
    // O(nlogn) solution
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        Arrays.sort(citations); // in ascending order
        int n = citations.length;
        if (citations[0] >= n) {
            return n;
        }
        int cur = n-1;   
        int res = 0;
        while (cur > 0) {
            int h = n - cur;
            if (citations[cur] < h) {
                break;
            }
            if (citations[cur-1]<= h) {
                res = h;
            }
            cur--;
        }
        return res;
    }// end of hindex     
    */
}



