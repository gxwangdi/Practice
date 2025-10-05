
class MinBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int res = start ^ goal;
        while (res > 0) {
            count ++;
            res = res & (res-1);
        }
        return count;
    }
}
