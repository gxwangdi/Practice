import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {

    private Map<String, List<Integer>> map;
    
    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        if (words == null || words.length ==0) {
            return;
        }
        for (int i=0; i<words.length; i++) {
            if (map.containsKey(words[i])) {
                List<Integer> list = map.get(words[i]);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        // Assuming list1 and list2 are not null.
        int cur1 = 0;
        int cur2 = 0;
        int min = Integer.MAX_VALUE;
        while (cur1<list1.size() && cur2<list2.size()) {
            min = Math.min(min, Math.abs(list1.get(cur1) - list2.get(cur2)) );
            if (list1.get(cur1) < list2.get(cur2)) {
                cur1++;
            } else {
                cur2++;
            }
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");


