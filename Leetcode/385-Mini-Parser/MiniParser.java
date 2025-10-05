import java.util.List;


 // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
 class NestedInteger {
      // Constructor initializes an empty nested list.
      public NestedInteger() {}
 
      // Constructor initializes a single integer.
      public NestedInteger(int value) {}
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger() {return true;}
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger() {return 0;}
 
      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value) {}
 
      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni) {}
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList() {return null;}
  }

public class MiniParser {
    
    public int helper(char[] cc, int s, NestedInteger res) {
        NestedInteger ret = null;
        Integer num = null;
        int sign = 1;
        while ( s<cc.length && cc[s] !=']') {
            char c = cc[s++];
            if (c == '[') {
                ret = new NestedInteger();
                s = helper(cc, s, ret);
            } else if (c == ',') {
                if (ret != null) { // a list
                    res.add(ret);
                } else {
                    if (num != null) { // an int
                        res.add(new NestedInteger(sign*num));
                    }
                }
                // finish one element, reset all.
                ret = null;
                num = null;
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else {
                num = num==null?(int)(c-'0'):(num*10)+(int)(c-'0');
            }
        }// end of while loop
        if (ret != null) {
            res.add(ret);
        } else if (num != null) {
            res.add(new NestedInteger(sign*num));
        }
        // starts from the next char.
        return s+1;
    }
    
    // Parse chars one by one.  
    public NestedInteger deserialize(String s) {
        NestedInteger res = new NestedInteger();
        helper(s.toCharArray(), 0, res);
        return res.getList().get(0);
    }
    
    /*
    // This is not like the reverse process, "[" might be parsed as part of number, if we set , as spliter.  
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() ==0) {
            return null;
        }
        if (s.startsWith("[") && s.endsWith("]")) { // create an array and return.
            s = s.substring(1, s.length()-1);    
            String[] arr = s.split("[,]");
            NestedInteger ni = new NestedInteger();
            for (String str : arr) {
                ni.add(deserialize(str));
            }
            return ni;
        } else {
            int val = Integer.parseInt(s);
            NestedInteger ni = new NestedInteger(val);    
            return ni;
        }
    }
    */
}









