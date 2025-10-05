import java.util.Arrays;
import java.util.Comparator;

public class SubarraySumClosest {
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
	public int[] subarraySumClosest(int[] nums) {
		int[] res = new int[2];
		if (nums == null || nums.length == 0) {
			return res;
		}

		int len = nums.length;
		if (len == 1) {
			res[0] = res[1] = 0;
			return res;
		}
		Pair[] sums = new Pair[len + 1];
		int prev = 0;
		sums[0] = new Pair(0, 0);
		for (int i = 1; i <= len; i++) {
			sums[i] = new Pair(prev + nums[i - 1], i);
			prev = sums[i].sum;
		}
		Arrays.sort(sums, new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				return a.sum - b.sum;
			}
		});
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= len; i++) {

			if (ans > sums[i].sum - sums[i - 1].sum) {
				ans = sums[i].sum - sums[i - 1].sum;
				int[] temp = new int[] { sums[i].index - 1, sums[i - 1].index - 1 };
				Arrays.sort(temp);
				res[0] = temp[0] + 1;
				res[1] = temp[1];
			}
		}

		return res;
	}
    
    /*
     // My implementation, it does not work for now. 
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        Arrays.fill(res, -1);
        if (nums == null || nums.length < 2) {
            return res;
        }
        
        int len = nums.length;
        Pair[] sums = new Pair[len+1];
        int prev = 0;
        for (int i=1; i<len; i++) {
            prev += nums[i-1];
            sums[i] = new Pair(prev, i-1);
        }
        Arrays.sort(sums, pairComparator);
        long min = Long.MAX_VALUE;
        for (int i=1; i<len+1; i++) {
            if (min > sums[i].sum - sums[i-1].sum ) {
                min = sums[i].sum - sums[i-1].sum;
                res[0] = sums[i].index;
                res[1] = sums[i-1].index;
            }
        }
        Arrays.sort(res);
        return res;
    }
    
    private Comparator<Pair> pairComparator = new Comparator<Pair>(){
        public int compare(Pair p1, Pair p2) {
            if (p1.sum > p2.sum) {
                return 1;
            } else if (p1.sum == p2.sum) {
                return 0;
            } else {
                return -1;
            }
        }
    };
    */
    
    
    private static class Pair 
        // implements Comparable<Pair>
    {
        public int sum;
        public int index;
        public Pair(int s, int i) {
            sum = s;
            index = i;
        }
        
        // In ascending order based on sum. 
        // public int compareTo(Pair p) {
        //     if (this.sum > p.sum) {
        //         return -1;
        //     } else if (this.sum == p.sum) {
        //         return 0;
        //     } else {
        //         return 1;
        //     }
        // }
    }
}
