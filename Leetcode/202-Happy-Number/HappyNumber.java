public class HappyNumber {
    /*
    public boolean isHappy(int n) {
        if (n<=0)
            return false;
        
        if (n==1)
            return true;
        
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        do {
            n = getHappy(n);
            if (set.contains(n))
                return false;
            set.add(n);
        } while (n!=1);
        return n==1;
    }// end 
    */
    public boolean isHappy(int n) {
        if (n<=0) 
            return false;
        if (n==1)
            return true;
        
        int slow = getHappy(n);
        int fast = getHappy(getHappy(n));
        while (slow != fast) {
            slow = getHappy(slow);
            fast = getHappy(getHappy(fast));
        }
        return fast == 1;
    } 
    
    private int getHappy(int n) {
        int total = 0;
        int temp;
        while (n!=0) {
            temp = n%10;
            total += temp*temp;
            n = n/10;
        }
        return total;
    }
}



