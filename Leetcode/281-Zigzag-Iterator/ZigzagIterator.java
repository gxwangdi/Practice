import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {

    private List<Integer> list;
    private int cur;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<>();
        cur = 0;
        int[] index = new int[2]; // could be replace with k. 
        List<List<Integer>> src = new ArrayList<>();
        src.add(v1);
        src.add(v2);
        int len = 0;
        while (len < v1.size() + v2.size()) {
            int temp = len%2; // could be replace with k.
            while (src.get(temp)==null || index[temp]>=src.get(temp).size()) {
                temp = (temp+1)%2;
            }
            list.add(src.get(temp).get(index[temp]));
            index[temp]++;
            len++;
        }
    }

    public int next() {
        int res = list.get(cur);
        cur++;
        return res;
    }

    public boolean hasNext() {
        return !(cur >= list.size());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
 
 
 
 
 
 