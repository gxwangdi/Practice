

class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        int[] dec=new int[n];
        for(int i=0;i<n;i++) {
            dec[i]=Integer.parseInt(nums[i],2);
        }
        Arrays.sort(dec);
        String str=Integer.toBinaryString(n);
        for(int i=0;i<n;i++)
        {
            if(dec[i]!=i)
            {
                str=Integer.toBinaryString(i);
                break;
            }
        }
        n=n-str.length();
        while(n>0) {
            str="0"+str;
            n--;
        }
        return str;
    }
}
