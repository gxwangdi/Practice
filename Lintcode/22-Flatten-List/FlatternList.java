import java.util.ArrayList;
import java.util.List;


//This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer,
	// rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds,
	// if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds,
	// if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class FlatternList {
	// @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> res = new ArrayList<>();
        if (nestedList == null || nestedList.size() == 0) {
            return res;
        }
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                res.add(ni.getInteger());
            } else {
                res.addAll(flatten(ni.getList()));
            }
        }
        return res;
    }// end of flatten
}
