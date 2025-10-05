public class AddDigits {
    public int addDigits(int num) {
        if (num/10 < 1) {
            return num;
        }
        
        num = Math.abs(num);
        return 1+((num-1)%9);
    }// end of addDigits    
}



