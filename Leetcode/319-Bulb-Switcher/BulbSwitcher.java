public class BulbSwitcher {
    public int bulbSwitch(int n) {
        if (n<1) {
            return 0;
        }
        int res = 1;
        while (res*res <=n) {
            res++;
        }
        return res -1;
    }// end of bulbSwitch       
}






