
public class FastPower {
	/*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    /*  // O(b)   Time limit exceeds. 
    public int fastPower(int a, int b, int n) {
        if (n == 0 || a == 1) {
            return 1%b;
        }
        if (a == 0) {
            return 0;
        }
        int exp = n;
        long x = a%b;
        List<Long> loop = new ArrayList<>();
        while (!loop.contains(x)) {
            loop.add(x);
            exp--;
            if (exp == 0) {
                return (int)x;
            }
            x = (x*a)%b;
        }
        int size = loop.size();
        int pos = n%size;
        long res = loop.get(pos-1);
        return (int)res;
    } */
    
    // O(logn) approach.  
	public int fastPower(int a, int b, int n) {
		if (n == 1) {
			return a % b;
		}
		if (n == 0) {
			return 1 % b;
		}
		long product = fastPower(a, b, n / 2);
		product = (product * product) % b;
		if (n % 2 == 1) {
			product = (product * a) % b;
		}
		return (int) product;
	}
}
