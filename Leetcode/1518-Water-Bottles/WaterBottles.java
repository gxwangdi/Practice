class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count=numBottles;
        int rem=numBottles%numExchange;
        numBottles/=numExchange;
        while(numBottles+rem>=numExchange)
        {
            count+=numBottles;
            int tmp=(numBottles+rem)%numExchange;
            numBottles=(numBottles+rem)/numExchange;
            rem=tmp;

        }
        count+=numBottles;
        return count;
    }
}
