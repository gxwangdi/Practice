import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    
    // Reference a posting in discuss. 
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), word.toCharArray(), 0, 0);
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder prog, char[] src, int i, int num) {
        int len = prog.length();
        if (i == src.length) {
            if (num!=0) {
                prog.append(num);
            }
            res.add(prog.toString());
        } else {
            dfs(res, prog, src, i+1, num+1); // abbr src[i]
            
            if (num!=0) {
                prog.append(num);
            }
            dfs(res, prog.append(src[i]), src, i+1, 0); // not abbr src[i]
        }
        prog.setLength(len); // backtracing.   
    }
    
    /* // this implementation is too....complecated. Basically it treats the problem as a tree.
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null) {
            return res;
        }
        res.add(word);
        if (word.length() == 0) {
            res.add("0");
            return res;
        }
        helper(res, word, 0, 1);
        return res;
    }// end of generateAbbreviations
    
    private void helper(List<String> res, String word, int start, int level) {
        if (start >= word.length()) {
            return;
        }
        if (level > 1) { // changes at pos start would reduce 1 char
            
            
        } else {
            char[] arr = word.toCharArray();
            for (int i=0; i<arr.length; i++) {
                char c = arr[i];
                arr[i] = level+'0';
                String s = new String(arr);
                res.add(s);
                helper(res, s, i+1, level+1);
            }
        }
    }// end of helper    
    */
}





