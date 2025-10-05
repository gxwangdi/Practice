

class FindThreeConsecutiveIntegersThatSumToAGivenNumber {
    public long[] sumOfThree(long num) {
        if(num%3 != 0) {
            return new long[0];
        }
        long [] ans = new long[3];
        long b = num/3;
        ans[0] = b-1;
        ans[1] = b;
        ans[2] = b+1;
        return ans;
    }
}
