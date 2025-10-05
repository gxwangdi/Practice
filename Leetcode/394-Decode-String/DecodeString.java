import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        int i = 0;
        result.push("");
        while ( i<s.length() ) {
            char ch = s.charAt(i);   
            if ( ch >= '0' && ch <= '9') {
                int start = i;
                while (s.charAt(i+1) >= '0' 
                    && s.charAt(i+1) <= '9') {
                    i++;
                }
                count.push(Integer.parseInt(s.substring(start, i+1))); 
            } else if ( ch == '[' ) {
                result.push("");
            } else if ( ch == ']' ) {
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j=0; j<times; j+=1) {
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop() + ch);
            }
            i += 1;
        }
        return result.pop();
    }// end of decodeString         
}







