

public class CountAndSay {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        String res = "1";
        if (n < 1) {
            return res;
        }
        StringBuilder sb;
        int count;
        for (int i = 1; i < n; i++) {
            sb = new StringBuilder();
            count = 1;
            char c = res.charAt(0);
            for (int j = 1; j < res.length(); j++) {
                if (c == res.charAt(j)) {
                    count++;
                    continue;
                }
                sb.append(count);
                sb.append(c);
                count = 1;
                c = res.charAt(j);
            }
            sb.append(count);
            sb.append(c);
            res = sb.toString();
        }
        return res;
    }
}

