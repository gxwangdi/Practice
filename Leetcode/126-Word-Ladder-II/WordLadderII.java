import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ladders = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        dict.add(start);
        dict.add(end);
        
        bfs(graph, distance, start, end, dict);
        
        dfs(ladders, new ArrayList<String>(), end, start, distance, graph);
        
        return ladders;
    }
    
    void dfs(List<List<String>> ladders, List<String> path, String crt,
            String start, Map<String, Integer> distance,
            Map<String, List<String>> map) {
        path.add(crt);
        if (crt.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(crt)) {
                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) { 
                    dfs(ladders, path, next, start, distance, map);
                }
            }           
        }
        path.remove(path.size() - 1);
    }
    
    private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        for (String s : dict) { // Would this create unnecessary space consumption? 
            map.put(s, new ArrayList<String>());
        }
        
        while (!q.isEmpty()) {
            String crt = q.poll();

            List<String> nextList = expand(crt, dict);
            for (String next : nextList) {
                map.get(next).add(crt);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(crt) + 1);
                    q.offer(next);
                }
            }
        }
    }// end of bfs
    
    
    private List<String> expand(String crt, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch
                            + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }
        return expansion;
    }
    
    /*
    // somehow my implementation does not work, mark this problem and no time to debug for now.
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> toFrom = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 0;
        distance.put(beginWord, level);
        q.offer(null);
        
        bfs(toFrom, distance, q, level+1, wordList, endWord);
        if (!toFrom.containsKey(endWord)) { // cannot reach.
            return res;
        }
        dfs(res, toFrom, distance, new ArrayList<String>(), endWord, beginWord);
        return res;
    }// end of findLadders     
    
    private void dfs(List<List<String>> res, Map<String, List<String>> toFrom, Map<String, Integer> distance, List<String> prog, String start, String end) {
        prog.add(start);
        if (start.equals(end)) {
            Collections.reverse(prog);
            res.add(prog);
            return;
        }
        int level = distance.get(start);
        List<String> dest = toFrom.get(start);
        for (String s : dest) {
            int dis = distance.get(s);
            if (dis >= level) {
                continue;
            }
            dfs(res, toFrom, distance, new ArrayList<String>(prog), s, end);
        }
    }
    
    private void bfs(Map<String, List<String>> toFrom, Map<String, Integer> distance, Queue<String> q, int level, Set<String> dict, String end) {
        boolean isLeaf = false;
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur == null) {
                if (isLeaf) {
                    break;
                }
                if (!q.isEmpty()) {
                    q.offer(null);
                }
                level++;
                continue;
            }
            
            char[] arr = cur.toCharArray();
            for(int i=0; i<arr.length; i++) {
                char temp = arr[i];
                for(char c='a'; c<='z'; c++) {
                    if (c == temp) {
                        continue;
                    }
                    arr[i]=c;
                    String s = new String(arr);
                    if (s.equals(end)) {
                        isLeaf = true;
                    }
                    if (!dict.contains(s)) { 
                        // not a valid word
                        continue;
                    }
                    if (distance.containsKey(s) && distance.get(s) < level) { 
                        // Not an optimal routine
                        continue;
                    }
                    distance.put(s, level);
                    if (toFrom.containsKey(s)) {
                        List<String> list = toFrom.get(s);
                        list.add(cur);
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(cur);
                        toFrom.put(s, list);
                    }
                    q.offer(s);
                }
            }
        }// end of q.isEmpty. 
    }// end of bfs
    */
}






