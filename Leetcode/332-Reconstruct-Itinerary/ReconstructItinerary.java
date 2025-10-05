import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {
    
    // DFS   
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            return null;
        }     
        
        Map<String, List<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (map.containsKey(ticket[0])) {
                List<String> list = map.get(ticket[0]);
                list.add(ticket[1]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(ticket[1]);
                map.put(ticket[0], list);
            }
        }
        for (String key : map.keySet()) {
            List<String> v = map.get(key);
            Collections.sort(v);
        }    
        
        List<String> res = new ArrayList<String>(); 
        res.add("JFK");
        helper(res, "JFK", map, tickets.length+1, 1);      
        return res;
    }
    
    // 
    private boolean helper(List<String> prog, String cur, Map<String, List<String>> map, int total, int num) {
        if (num >= total) {
            return true;
        }
        
        if (!map.containsKey(cur) || map.get(cur).isEmpty()) {
            return false;
        }
        
        List<String> list = map.get(cur);
        for (int i=0; i<list.size(); i++) {
            String s = list.get(i);
            list.remove(s);
            prog.add(s);
            if (helper(prog, s, map, total, num+1)) {
                return true;
            }
            prog.remove(prog.size()-1);
            list.add(i, s);
        }
        return false;
    }
    
    /*
    private boolean isFinish(Map<String, List<String>> map) {
        for(String s : map.keySet()) {
            if (map.get(s).size()>0) {
                return false;
            }
        }
        return true;
    }
    */
    
    /* // understand the problem incorrectly.        
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.length == 0) {
            return res;
        }
        Map<String, Queue<String>> map = new HashMap<>();
        for (String[] ticket: tickets) {
            if (map.containsKey(ticket[0])) {
                Queue<String> list = map.get(ticket[0]);
                list.offer(ticket[1]);
            } else {
                Queue<String> list = new PriorityQueue<>();
                list.offer(ticket[1]);
                map.put(ticket[0], list);
            }
        }// end of map init
        
        String cur = "JFK"; // Assuming it is always available.
        res.add(cur);
        while (cur != null) {
            if (!map.containsKey(cur)) {
                cur = null;
                continue;
            }
            
            Queue<String> list = map.get(cur);
            if (list.size()==0) {
                cur = null;
                continue;
            }
            
            cur = list.poll();
            res.add(cur);
        }
        return res;
    }// end of findItinerary     
    */
}



