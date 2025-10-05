
class MinMovesToReachTargetScore {
    public int minMoves(int target, int maxDoubles) {
        int step =0;

        while(target != 1) {
            if(target % 2 == 0 && maxDoubles != 0) {
                target/=2;
                maxDoubles--;
                step++;
            }
            else{
                if(maxDoubles == 0) {
                    step+= target-1;
                    break;
                }
                target--;
                step++;
            }
        }
        return step;
    }
}
