import java.util.Stack;

public class VerifyPreorderSequenceInBinarySearchTree {
    
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack<>();
        for (int p : preorder) {
            if (p < low) {
                return false;
            }
            while (!path.isEmpty() && p>path.peek()) {
                low = path.pop();
            }
            path.push(p);
        }
        return true;
    }
    
    /*
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <2) {
            return true;
        }
        return verify(preorder, 0, preorder.length-1);
    }// end of verifyPreorder    
    
    private boolean verify(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }
        int pivot = arr[start];
        int bigger = -1;
        for (int i=start+1; i<=end; i++) {
            if (bigger==-1 && arr[i]>pivot) {
                bigger = i;
            }
            if (bigger!=-1 && arr[i]<pivot) {
                return false;
            }
        }
        if (bigger == -1) { // all left tree
            return verify(arr, start+1, end);
        } else {
            return verify(arr, start+1, bigger-1) && verify(arr, bigger, end);
        }
    }
    */
}





