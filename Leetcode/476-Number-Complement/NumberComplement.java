
class NumberComplement {
    public int findComplement(int num) {
        //it gives number of digits in binary form of a number
        int digit=(int)(Math.log(num)/Math.log(2))+1;
        // (it gives next power of 2)-1 // It gives all digits as 11111...
        int mask=(1<<digit)-1;
        return num^mask;
    }
}
