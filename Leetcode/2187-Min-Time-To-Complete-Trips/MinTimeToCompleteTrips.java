

class MinTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        long mx = time[0];
            for (Integer i : time) {
                if (i > mx) {
                    mx = i;
                }
            }

            long left = 0, right = mx * totalTrips, mid;
            long cnt;
            long ans = Long.MAX_VALUE;
            while (left <= right) {
                cnt = 0;
                mid = left + (right - left) / 2;
                for (int i = 0; i < time.length; i++)
                    cnt += mid / time[i];
                if (cnt >= totalTrips) {
                    if (mid < ans)
                        ans = mid;
                    right = mid - 1;
                } else
                    left = mid + 1;
            }
            return ans;
    }
}
