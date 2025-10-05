
public class FlipBits {
	/**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int res = a^b;
        int count = 0;
        while (res!=0) {
            res = (res & (res-1));
            count++;
        }
        return count;
    }
}
