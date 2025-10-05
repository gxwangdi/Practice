import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class FlattenNestedListIterator implements Iterator<Integer>{
	private int cur;
    private List<Integer> list;
    
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        cur = 0;
        list = new ArrayList<>();
        if (nestedList == null || nestedList.size() == 0) {
            return;
        }
        buildList(list, nestedList);
    }
    
    private void buildList(List<Integer> res, List<NestedInteger> src) {
        for (NestedInteger ni : src) {
            if (ni.isInteger()) {
                res.add(ni.getInteger());
            } else {
                buildList(res, ni.getList());
            }
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        Integer value = list.get(cur);
        cur++;
        return value;
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        return cur < list.size();
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */


