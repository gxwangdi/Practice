import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length()<10) {
            return res;
        }
        Set<String> set = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i=0; i+10<=s.length(); i++) {
            String cur = s.substring(i, i+10);
            if (set.contains(cur)) {
                repeated.add(cur);
            } else {
                set.add(cur);
            }
        }
        res.addAll(repeated);
        return res;
    }// end of findRepeatedDnaSequences
}







