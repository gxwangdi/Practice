
public class DropEggs {
	/**
     * @param n an integer
     * @return an integer
     */
    // From jiuzhang
    public int dropEggs(int n) {
        long ans = 0;
        int i = 1;
        while (true) {
            ans += (long) i;
            if (ans >= (long) n) {
                return i;
            }
            i++;
        }
    }
}


