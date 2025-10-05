

class Dominoandtrominotiling {
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n <= 2) {
            return n;
        }
        long fPrevious = 1L;
        long fCurrent = 2L;
        long pCurrent = 1L;
        for (int k = 3; k < n + 1; ++k) {
            long tmp = fCurrent;
            fCurrent = (fCurrent + fPrevious + 2 * pCurrent) % MOD;
            pCurrent = (pCurrent + fPrevious) % MOD;
            fPrevious = tmp;
        }
        return (int) (fCurrent);
    }
}
