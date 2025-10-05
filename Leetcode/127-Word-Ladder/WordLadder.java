import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    
    private final int INVALID_DISTANCE = 0;
    
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null 
            || endWord == null 
            || wordList == null 
            || beginWord.length()!=endWord.length()) {
            return INVALID_DISTANCE;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        queue.offer(null);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur == null) {
                level++;  
                if (!queue.isEmpty()) {
                    queue.offer(null);
                    continue;
                } else {
                    break;
                }
            }// end of one layer
            
            char[] arr = cur.toCharArray();
            for (int i=0; i<arr.length; i++) {
                char temp = arr[i];
                for (char c='a'; c<='z'; c++) {
                    arr[i] = c;
                    String s = new String(arr);
                    if (s.equals(endWord)) {
                        return level+1;
                    }
                    if (wordList.contains(s) && !visited.contains(s)) {
                        queue.offer(s);
                        visited.add(s);
                    }
                }
                arr[i] = temp;
            }
        }
        return INVALID_DISTANCE;
    }// end of ladder
}



