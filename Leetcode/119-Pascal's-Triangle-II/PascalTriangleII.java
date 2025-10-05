import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex <0) 
            return null;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        if (rowIndex == 0) {
            return cur;
        }
        cur.add(1);
        if (rowIndex == 1) {
            return cur;
        }
        List<Integer> next = new ArrayList<>();
        int k=2;
        while (k<=rowIndex) {
            for (int i=0; i<=k; i++) {
                if (i == 0 || i==k) {
                    next.add(1);
                    continue;
                }
                next.add(cur.get(i-1) + cur.get(i));
            }
            cur = next;
            next = new ArrayList<>();
            k++;
        }
        return cur;
    }
}