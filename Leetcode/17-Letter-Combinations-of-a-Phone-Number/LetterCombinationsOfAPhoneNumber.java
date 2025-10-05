import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    // public List<String> letterCombinations(String digits) {
    //     List<String> res = new ArrayList<>();
    //     if (digits == null || digits.length() == 0) {
    //         return res;
    //     }
    //     res.add("");
    //     Map<Character, String> map = getMappings();
    //     for (int i=0; i<digits.length(); i++) {
    //         List<String> level = new ArrayList<>();
    //         char c = digits.charAt(i);
    //         if (!map.containsKey(c)) {
    //             continue;
    //         }
    //         String value = map.get(c);
    //         for (int j=0; j<res.size(); j++) {
    //             for (int k=0; k<value.length(); k++) {
    //                 level.add(res.get(j) + value.charAt(k));
    //             }
    //         }
    //         res = level;
    //     }
    //     return res;
    // }
    //
    // private Map<Character, String> getMappings(){
    //     Map<Character, String> map = new HashMap<>();
    //     map.put('2', "abc");
    //     map.put('3', "def");
    //     map.put('4', "ghi");
    //     map.put('5', "jkl");
    //     map.put('6', "mno");
    //     map.put('7', "pqrs");
    //     map.put('8', "tuv");
    //     map.put('9', "wxyz");
    //     map.put('0', " ");
    //     return map;
    // }

    // Updated 06/12/2022
    class Solution {
    public List<String> letterCombinations(String digits) {
        var list = new ArrayList<String>();
        if (digits == null || digits.length() <1) {
            return list;
        }
        var map = Map.of('2', Set.of('a','b','c'),'3',Set.of('d','e','f'),'4',Set.of('g','h','i'),'5',Set.of('j','k','l'),'6',Set.of('m','n','o'),'7',Set.of('p','q','r','s'),'8',Set.of('t','u','v'),'9',Set.of('w','x','y','z'));

        helper(digits, 0, map, new StringBuilder(), list);
        return list;
    }

    private void helper(String str, int index, Map<Character, Set<Character>> map, StringBuilder sb, List<String> res) {
        if (index == str.length()) {
            res.add(sb.toString());
            return;
        }
        char cur = str.charAt(index);
        var set = map.get(cur);
        for(char c : set) {
            int i = sb.length();
            sb.append(c);
            helper(str, index+1, map, sb, res);
            sb.setLength(i);
        }
    }
}
}
