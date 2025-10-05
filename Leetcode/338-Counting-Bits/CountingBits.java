public class CountingBits {
    
    public int[] countBits(int num) {
        if (num < 0) {
            return null;
        } 
        int[] res = new int[num+1];
        res[0] = 0;
        for (int i=1; i<res.length; i++) {
            if (i%2 == 0) {
                res[i] = res[i/2];
            } else {
                res[i] = res[i/2]+1;
            }
        }
        return res;
    }
    
    /* // res[i] = res[i&(i-1)] + 1, starts from res[1]. 
    public int[] countBits(int num) {
        if (num <0) {
            return null;
        }
        int[] res = new int[num+1];
        res[0] = 0; 
        for (int i=1; i<res.length; i++) {
            res[i] = res[i&(i-1)] +1;
        }
        return res;
    }*/
}






