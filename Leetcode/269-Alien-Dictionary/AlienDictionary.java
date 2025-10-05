import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
    
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        StringBuilder res = new StringBuilder();
        if (words == null || words.length == 0) {
            return res.toString();
        }
        
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }// init degree mapping
        
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) {
                        set=map.get(c1);
                    }
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }// end of words.length-1 loop
        
        Queue<Character> q = new LinkedList<>();
        for (char c:degree.keySet()) {
            if (degree.get(c) == 0) {
                q.offer(c);
            }
        }
        while(!q.isEmpty()) {
            char c=q.poll();
            res.append(c);
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) {
                        q.add(c2);
                    }
                }
            }
        }
        if (res.length()!=degree.size()) { // there is loop !  
            return "";
        }
        return res.toString();
    }
    
    /*
    // My implementation does not work for illegal input, like ['a', 'b', 'a']. 
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i=0; i<words.length-1; i++) {
            int cur = 0;
            while (cur<words[i].length() && cur<words[i+1].length()) {
                char c1 = words[i].charAt(cur);
                char c2 = words[i+1].charAt(cur);
                if (!map.containsKey(c1)) {
                    map.put(c1, new HashSet<Character>());
                }
                if (!map.containsKey(c2)) {
                    map.put(c2, new HashSet<Character>());
                }
                if (c1 != c2) {
                    map.get(c1).add(c2);
                    break;
                }
                cur++;
            }
            // Not all words are in the same length, collect all the chars.
            String s = words[i].length()>words[i+1].length()?words[i]:words[i+1];
            while (cur < s.length()) {
                char c = s.charAt(cur);
                if (!map.containsKey(c)) {
                    map.put(c, new HashSet<Character>());
                }
                cur++;
            }
        }// map init
        
        StringBuilder sb = new StringBuilder(map.size());
        for (Character c : map.keySet()) {
            int cur = 0;
            while (cur<sb.length() && !map.get(c).contains(sb.charAt(cur))) {
                cur++;
            }
            sb.insert(cur, c);
        }
        return sb.toString();
    }
    */
}





