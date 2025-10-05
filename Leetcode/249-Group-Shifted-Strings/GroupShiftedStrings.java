import java.util.ArrayList;
import java.util.List;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return res;
        }
        for (String s : strings) {
            boolean isExist = false;
            for (List<String> list : res) {
                String a = list.get(0);
                if (isShifted(a, s)) {
                    list.add(s);
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                List<String> list = new ArrayList<>();
                list.add(s);
                res.add(list);
            }
        }
        return res;
    }
    
    private boolean isShifted(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String ss1 = getStandardRotation(s1);
        String ss2 = getStandardRotation(s2);
        return ss1.equals(ss2);
    }
    
    // rotate so that it starts with 'a'
    private String getStandardRotation(String s) {
        int cur = 0;
        int diff = alphabet.indexOf(s.charAt(cur)+"");
        if (diff == 0) {
            return s;
        }
        cur++;
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        while (cur < s.length()) {
            int i = alphabet.indexOf(s.charAt(cur)+"");
            i = (i-diff + 26)%26;
            sb.append(alphabet.charAt(i));
            cur++;
        }
        return sb.toString();
    }
    
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
}




