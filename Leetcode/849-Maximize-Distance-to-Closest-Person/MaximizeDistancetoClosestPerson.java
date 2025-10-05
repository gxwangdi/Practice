public class MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int max = maxZeroDistance(seats);
        if (max % 2 == 1) {
            return max/2 + 1;
        }
        return max/2;
    }

    private int maxZeroDistance(int[] seats) {
        boolean isBeginning = true;
        int max = 0;
        int count = 0;
        for(int i=0; i<seats.length; i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                if (isBeginning) {
                    max = Math.max(max, count*2);
                } else {
                    max = Math.max(max, count);
                }
                isBeginning = false;
                count=0;
            }
        }
        if (count != 0) {
            max = Math.max(max, count*2);
        }
        return max;
    }
}
