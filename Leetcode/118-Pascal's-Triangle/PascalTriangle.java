import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows <1) {
            return res;
        }
        for (int row =1; row <= numRows; row++) {
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<row; j++) {
                if (j==0 || j==row-1) {
                    list.add(1);
                    continue;
                }
                if (row>2) {
                    list.add(res.get(row-2).get(j-1) + res.get(row-2).get(j));
                }
            }
            res.add(list);
        }
        
        return res;
    }
}