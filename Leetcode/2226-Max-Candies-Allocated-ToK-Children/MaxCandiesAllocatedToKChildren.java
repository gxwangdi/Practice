

class MaxCandiesAllocatedToKChildren {
    public int maximumCandies(int[] candies, long k) {
        int max = candies[0];
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        int min = 0;
        while (min < max) {
            int mid = ((min + max) / 2) + 1;
            long cnt = 0;
            for (int candy : candies) {
                cnt += candy / mid;
            }

            if (cnt >= k) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }
}
