import java.util.ArrayList;
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
public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return getSum(nestedList, 0);
    }
    
    private int getSum(List<NestedInteger> src, int prevSum) {
        int intSum = prevSum;
        List<NestedInteger> levelbreak = new ArrayList<>();
        
        for (NestedInteger ni : src) {
            if (ni.isInteger()) {
                intSum += ni.getInteger();
            } else {
                levelbreak.addAll(ni.getList()); // Flatten the structure.
            }
        }
        // In this way, sum in upper level gets one more addition.  
        int listSum = levelbreak.isEmpty()?0:getSum(levelbreak, intSum);
        return listSum + intSum;
    }
}



