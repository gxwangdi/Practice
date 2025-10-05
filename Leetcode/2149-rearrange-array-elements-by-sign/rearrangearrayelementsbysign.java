

class rearrangearrayelementsbysign {
    public int[] rearrangeArray(int[] nums) {
        int[] res=new int[nums.length];
        int pi=0;
        int ni=1;
        for(int n:nums){
            if(n>0){
                res[pi]=n;
                pi+=2;
            }else{
                res[ni]=n;
                ni+=2;
            }
        }
        return res;
    }
}
