import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();           
        int cur = 0;
        while (cur < s.length()) {           
            int slash = s.indexOf('/', cur);        
            int size = Integer.valueOf(s.substring(cur, slash));       
            res.add(s.substring(slash+1, slash+size+1));         
            cur = slash + size + 1;        
        }
        return res;       
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));





