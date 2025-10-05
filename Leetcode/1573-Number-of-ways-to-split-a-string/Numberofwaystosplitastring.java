

class Numberofwaystosplitastring {
    private static final int modulo = 1000000007;

    public int numWays(String s) {
        // int num = Integer.parseInt(s, 2);
        // int tc = numOne(num);
        int tc = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                tc++;
            }
        }
        if (tc == 0) {
            return getModResult(s.length()-1, s.length()-2);
        }
        if (tc%3 !=0) {
            return 0;
        }
        tc = tc/3;
        long x1 = getLeft(s, tc);
        long x2 = getRight(s, tc);
        // return getModResult(x1, x2);
        // long res = (long)((x1%modulo) * (x2%modulo)) % modulo;
        return (int)((x1%modulo) * (x2%modulo) %modulo);
    }

    private int getModResult(long x1, long x2) {
        x1 = x1%modulo;
        x2 = x2%modulo;
        long res = x1 * x2 / 2 % modulo;
        return (int)res;
    }

    private long getLeft(String s, int tc) {
        int cur = 0;
        while(tc>0) {
            if (s.charAt(cur) == '1') {
                tc--;
            }
            cur++;
        }
        long res = 0;
        while (s.charAt(cur) != '1') {
            res++;
            cur++;
        }
        return res+1;
    }

    private long getRight(String s, int tc) {
        int cur = s.length()-1;
        while(tc>0) {
            if (s.charAt(cur) == '1') {
                tc--;
            }
            cur--;
        }
        long res = 0;
        while (s.charAt(cur) != '1') {
            res++;
            cur--;
        }
        return res+1;
    }

    // private int numOne(int num) {
    //     int res =0;
    //     while(num>0) {
    //         num = num & (num-1);
    //         res++;
    //     }
    //     return res;
    // }
}
