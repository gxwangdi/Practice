import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        List<String> line = new ArrayList<>();
        int cur = 0;
        int sum = 0;
        while (cur < words.length) {
            if (maxWidth >= sum + words[cur].length() + line.size()) {
                sum += words[cur].length();
                line.add(words[cur]);
                cur++;
            } else {
                String s = getLine(line, maxWidth, sum);
                res.add(s);
                line.clear();
                sum = 0;
            }
        }
        if (line.size() > 0) {
            String s = appendLine(line, maxWidth);
            res.add(s);
        }
        return res;
    }// end of fullJustify
    
    
    private String getLine(List<String> line, int maxWidth, int sum) {
        if (line.size() == 1) {
            return appendLine(line, maxWidth);
        }
        int len = (maxWidth - sum)/(line.size()-1);
        int carry = (maxWidth - sum)%(line.size()-1);
        StringBuilder sb = new StringBuilder(maxWidth);
        sb.append(line.get(0));
        for (int i=1; i<line.size(); i++) {
            for (int j=0; j<len; j++) {
                sb.append(" ");
            }
            if (i<=carry) {
                sb.append(" ");
            }
            sb.append(line.get(i));
        }
        return sb.toString();
    }// end of getLine     
    
    
    private String appendLine(List<String> line, int maxWidth) {
        StringBuilder sb = new StringBuilder(maxWidth);
        int sum = line.get(0).length();
        sb.append(line.get(0));
        for (int i=1; i<line.size(); i++) {
            sum += 1 + line.get(i).length();
            sb.append(" ");
            sb.append(line.get(i));
        }
        sum = maxWidth - sum;
        while (sum>0) {
            sb.append(" ");
            sum--;
        }
        return sb.toString();
    }// end of appendLine
}



