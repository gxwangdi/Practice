import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfSmallerNumbersAfterSelf {
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int len = nums.length;
        Node[] node = new Node[len];    
        
        // Build a HashMap to store the index and corresponding node
        Map<Integer, Node> map = new HashMap<>();
        for (int i=0; i<len; i++) {
            Node temp = new Node(nums[i]);
            node[i] = temp;
            map.put(i, temp);
        }// end of i loop
        
        Node[] helper = new Node[len];
        mergeSort(node, helper, 0, len-1);
        
        for (int i=0; i<len; i++) {
            Node temp = map.get(i);
            res.add(temp.count);
        }
        return res;
    }// end of countSmaller      
    
    public void mergeSort(Node[] node, Node[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right-left)/2;
        
        mergeSort(node, helper, left, mid);
        mergeSort(node, helper, mid+1, right);    
        
        merge(node, helper, left, right, mid);
    }// end of mergeSort            
    
    public void merge(Node[] node, Node[] helper, int left, int right, int mid) {
        for (int i=left; i<=right; i++) {
            helper[i] = node[i];
        }
        
        int i = left;
        int j = mid+1;
        int k = left;
        while (i <= mid || j <= right) {
            if (i > mid) {
                node[k] = helper[j];
                j++;
            } else if (j > right) {
                node[k] = helper[i];
                i++;
            } else if (helper[i].val > helper[j].val) {
                node[k] = helper[i];
                helper[i].count += right-j+1;
                i++;
            } else {
                node[k] = helper[j];
                j++;
            }
            k++;
        }
    }// end of merge      
    
    private static class Node {
        int val;
        int count;
        
        public Node(int val) {
            this.val = val;
            count = 0;
        }
    }
}







