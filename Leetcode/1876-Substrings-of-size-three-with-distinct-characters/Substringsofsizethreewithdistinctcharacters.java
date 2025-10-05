
class Substringsofsizethreewithdistinctcharacters {
    public int countGoodSubstrings(String s) {
        final int k = 3;
        int res = 0;
        if (s == null || s.length() < k) {
            return res;
        }

        var map = new HashMap<Character, Integer>();
        for(int i=0; i<k; i++) {
            int count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count+1);
        }
        if (map.size() == k) {
            res +=1;
        }
        for(int i=k; i<s.length(); i++) {
            int count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count+1);
            count = map.get(s.charAt(i-k));
            if (count == 1) {
                map.remove(s.charAt(i-k));
            } else {
                map.put(s.charAt(i-k), count-1);
            }
            if (map.size() ==k) {
                res += 1;
            }
        }
        return res;
    }
}
