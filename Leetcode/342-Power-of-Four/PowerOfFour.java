public class PowerOfFour {
    /*
    public boolean isPowerOfFour(int num) {
        if (num <=0) 
            return false;
        
        // num = Math.abs(num);
        while (num!=1) {
            if (num%4 != 0) {
                return false;
            }
            num = num/4;
        }
        return true;
    }// end 
    */
    public boolean isPowerOfFour(int num) {
        if (num<=0)
            return false;
        
        if (num==1)
            return true;
        
        String bi = Integer.toBinaryString(num);
        if (bi.length()%2 == 0) 
            return false;
        
        bi = bi.replaceAll("00", "");
        return bi.equals("1");   
    }
}