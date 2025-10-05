
/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/

class SVNRepo {
	public static boolean isBadVersion(int k) {
		return true;
	}
}

public class FirstBadVersion {

	/**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }
        int start = 1; 
        int end = n; 
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (SVNRepo.isBadVersion(start)) {
            return start;
        }
        if (SVNRepo.isBadVersion(end)) {
            return end;
        }
        return -1;
    }
}
