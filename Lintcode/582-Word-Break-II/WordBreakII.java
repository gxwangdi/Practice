import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	/*
     * @param s: A string
     * @param dict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null) {
            return null;
        }
        List<String> ret = new ArrayList<String>();
        List<String> path = new ArrayList<String>();
        int len = s.length();
        boolean[] D = new boolean[len + 1];
        D[len] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j <= len - 1; j++) {
                D[i] = false;
                if (D[j + 1] && dict.contains(s.substring(i, j + 1))) {
                    D[i] = true;
                    break;
                }
            }
        }
        dfs4(s, dict, path, ret, 0, D);
        return ret;
    }
    
    public static void dfs4(String s, Set<String> dict, List<String> path, List<String> ret, int index, boolean canBreak[]) {
        int len = s.length();
        if (index == len) {
            StringBuilder sb = new StringBuilder();
            for (String str: path) {
                sb.append(str);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            ret.add(sb.toString());
            return;
        }
        
        if (!canBreak[index]) {
            return;
        }
        
        for (int i =  index; i < len; i++) {
            String left = s.substring(index, i + 1);
            if (!dict.contains(left)) {
                continue;
            }
            path.add(left);
            dfs4(s, dict, path, ret, i + 1, canBreak);
            path.remove(path.size() - 1);
        }
    }
}
