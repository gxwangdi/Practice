
class MakeTwoArraysEqualByReversingSubarray {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target==null||arr==null)
            return false;
        int[] count = new int[1000];
        for(int n: target) {
            count[n-1]++;
        }
        for(int k: arr) {
            count[k-1]--;
            if(count[k-1]<0)
                return false;
        }
        return true;
    }
}
