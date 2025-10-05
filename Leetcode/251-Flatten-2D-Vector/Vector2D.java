import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Vector2D implements Iterator<Integer> {

    private List<Integer> list;
    private int cur;
    
    public Vector2D(List<List<Integer>> vec2d) {
        list = new ArrayList<>();
        cur = 0;
        if (vec2d != null) {
            for (int i=0; i<vec2d.size(); i++) {
                if (vec2d.get(i) == null) {
                    continue;
                }
                for (int j=0; j<vec2d.get(i).size(); j++) {
                    list.add(vec2d.get(i).get(j));
                }
            }
        }
    }

    @Override
    public Integer next() {
        Integer res = list.get(cur);
        cur++;
        return res;
    }

    @Override
    public boolean hasNext() {
        return !(cur >= list.size());
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
 
 
 
 
 