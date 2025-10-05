import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int cur = 1;
        for (int i=1; i<=n; i++) {
            list.add(cur);
            if (cur *10 <= n) {
                cur *= 10;
            } else if (cur%10!=9 && cur+1<=n) {
                cur++;
            } else {
                while ( (cur/10)%10 == 9) {
                    cur /= 10;
                }
                cur = cur/10+1;
            }
        } 
        return list;
    }
}







