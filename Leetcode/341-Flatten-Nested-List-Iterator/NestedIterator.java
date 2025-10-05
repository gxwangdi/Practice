import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> mList;
    private int cur;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        mList = new ArrayList<>();
        cur = 0;
        if (nestedList!=null && nestedList.size()>0) {
            buildList(nestedList, mList);
        }
    }
    
    private void buildList(List<NestedInteger> src, List<Integer> res) {
        for (NestedInteger ni : src) {
            if (ni.isInteger()) {
                res.add(ni.getInteger());
            } else {
                buildList(ni.getList(), res);
            }
        }
    }

    @Override
    public Integer next() {
        Integer i = mList.get(cur);
        cur++;
        return i;
    }

    @Override
    public boolean hasNext() {
        return cur<mList.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */