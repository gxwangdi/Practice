

class Findwordsthatcanbeformedbycharacters {
    public int countCharacters(String[] words, String chars) {
        var res = 0;
        if (words == null || words.length <1) {
            return res;
        }
        var counts = new int[26];
        for (char c : chars.toCharArray()) {
            counts[c-'a'] ++;
        }
        for (String s : words) {
            if (s.length() > chars.length()) {
                continue;
            }
            var temp = new int[26];
            var flag = true;
            for (char c : s.toCharArray()) {
                var index = c-'a';
                temp[index]++;
                if (temp[index] > counts[index]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += s.length();
            }
        }
        return res;
    }
}
