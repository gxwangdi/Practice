public class HIndexII {
    
    // Binary Search
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int left = 0;
        int right = len-1;
        int mid;
        while (left <= right) {
            mid=left+ (right-left)/2;
            if(citations[mid] >= (len-mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }
    
    /*
    // Binary search
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        // if (citations[0]>=n) {
        //     return n;
        // }
        int start = 0;
        int end = n-1;
        while (start + 1 < end) {
            int mid = start + (end-start)/2;
            int h = n - mid;
            if (citations[mid] == h) {
                start = mid;
            } else if (citations[mid] < h) {
                start = mid +1;
            } else {
                end = mid;
            }
        }
        
        int h = n - end;
        if (citations[end]>=h) {
            return h;
        }
        h = n - start;
        if (citations[start]>=h) {
            return h;
        }
        return citations.length;
    }
    */
    
    /*
    // O(n)
    public int hIndex(int[] citations) {
        int res = 0;
        if (citations == null || citations.length == 0) {
            return res;
        }
        
        int n = citations.length;
        if (citations[0] >= n) {
            return n;
        }
        int cur = n-1;
        while (cur > 0) {
            int h = n - cur;
            if (citations[cur] < h) {
                break;
            }
            if (citations[cur-1] <= h) {
                res = h;
            }
            cur--;
        }
        return res;
    }
    */
}



