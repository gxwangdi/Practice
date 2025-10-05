

class Validwordabbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }
    // public boolean validWordAbbreviation(String word, String abbr) {
    //     int i1 = 0;
    //     int i2 = 0;
    //     while(i1<word.length()) {
    //         if (i2 >= abbr.length()) {
    //             return false;
    //         }
    //         if(abbr.charAt(i2) >= '0' && abbr.charAt(i2) <='9') {
    //             int i3 = i2;
    //             while(i3 < abbr.length() && abbr.charAt(i3) >= '0' && abbr.charAt(i3) <='9') {
    //                 i3++;
    //             }
    //             String num = abbr.substring(i2, i3);
    //             if (num.startsWith("0")) {
    //                 return false;
    //             }
    //             int len = Integer.parseInt(num);
    //             if (i1 + len > word.length()) {
    //                 return false;
    //             }
    //             i2 = i3;
    //             i1 = i1 + len;
    //             continue;
    //         }
    //         char c = word.charAt(i1);
    //         if (i2 >= abbr.length() || abbr.charAt(i2) != c) {
    //             return false;
    //         }
    //         i1++;
    //         i2++;
    //     }
    //     return i2 == abbr.length();
    // }
}
