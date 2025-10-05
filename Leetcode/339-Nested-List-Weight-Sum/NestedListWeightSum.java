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
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size()==0) {
            return 0;
        }
        return getSum(nestedList, 1);
    }
    
    private int getSum(List<NestedInteger> src, int level) {
        int sum = 0;
        for (NestedInteger ni : src) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * level;
            } else {
                sum += getSum(ni.getList(), level+1);
            }
        }
        return sum;
    }
}



