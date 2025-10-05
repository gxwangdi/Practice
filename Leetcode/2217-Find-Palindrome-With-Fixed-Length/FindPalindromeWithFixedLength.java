

class FindPalindromeWithFixedLength {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long minHalf=(long)Math.pow(10,(intLength-1)/2);
        long maxIndex=(long)Math.pow(10,(intLength+1)/2)-minHalf;
        boolean isOdd=intLength%2==1;
        long res[]=new long[queries.length];
        for(int i=0;i<res.length;i++){
            res[i]=queries[i]>maxIndex?-1:helper(queries[i],minHalf,isOdd);
        }
        return res;
    }

    private long helper(long index,long minHalf,boolean isOdd){
        long half=minHalf+index-1;
        long res=half;
        if(isOdd){
            res/=10;
        }
        while(half!=0){
            res=res*10+half%10;
            half/=10;
        }
        return res;
    }
}
