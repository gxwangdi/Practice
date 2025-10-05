

class Numberofstepstoreduceanumbertozero {
    public int numberOfSteps(int num) {
        var bStr = Integer.toBinaryString(num);
        return bStr.length() + numberOfOnes(num) - 1;
    }

    private int numberOfOnes(int num) {
        var res = 0;
        while(num>0) {
            num = num & (num-1);
            res ++;
        }
        return res;
    }
}
