import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length()<2) {
            return res;
        }
        char[] arr = s.toCharArray();           
        int cur = 0;
        while (cur < arr.length-1) {           
            if (arr[cur+1]!='+') {
                cur += 2;
                continue;
            }
            if (arr[cur]!='+') {
                cur++;
                continue;
            }
            String ss = getString(arr, cur);         
            res.add(ss);
            cur++;
        }
        return res;          
    }
    
    private String getString(char[] arr, int i) {
        arr[i] = arr[i+1] = '-';
        String res = new String(arr);
        arr[i] = arr[i+1] = '+';
        return res;
    }
}






