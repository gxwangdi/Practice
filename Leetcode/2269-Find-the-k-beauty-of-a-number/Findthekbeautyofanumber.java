

class Findthekbeautyofanumber {
    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int res = 0;
        if (str.length() < k) {
            return res;
        }
        for(int i=0; i+k<=str.length(); i++) {
            int temp = Integer.parseInt(str.substring(i, i+k));
            if (temp == 0) {
                continue;
            }
            if (num % temp == 0) {
                res += 1;
            }
        }
        return res;
    }
}
