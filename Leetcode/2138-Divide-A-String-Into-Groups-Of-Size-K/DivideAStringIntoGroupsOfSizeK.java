
class DivideAStringIntoGroupsOfSizeK {
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>();
        int cur = 0;
        while ((cur+1)*k <= s.length()) {
            res.add(s.substring(cur*k, (cur+1)*k));
            cur++;
        }
        if (cur*k != s.length()) {
            StringBuilder sb = new StringBuilder();
            for(int i=cur*k; i<s.length(); i++) {
                sb.append(s.charAt(i));
            }
            while(sb.length() < k) {
                sb.append(fill);
            }
            res.add(sb.toString());
        }
        String[] arr = new String[res.size()];
        res.toArray(arr);
        return arr;
    }
}
