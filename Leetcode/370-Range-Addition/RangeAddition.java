public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];     
        for (int[] update : updates) {
            res[update[1]] +=update[2];
            if (update[0] > 0) {
                res[update[0]-1] -=update[2];
            }
        }
        
        int sum = res[length-1];
        for (int i=length-2; i>=0; i--) {
            int tmp = sum + res[i];
            res[i] += sum;
            sum = tmp;
        }
        return res;
    }// end of getModifiedArray       
}






