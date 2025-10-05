
class ComplementOfBase10Integer {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int power=0;
        int reversed=0;
        while(n>0){
            int digit=n%2;
            if(digit==0)
             reversed= reversed + (int)Math.pow(2,power);
            power++;
            n/=2;
        }
        return reversed;
    }
}
