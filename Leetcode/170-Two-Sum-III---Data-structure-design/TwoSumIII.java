import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {

    private Map<Integer, Integer> map = new HashMap<>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)) {
	        map.put(number, map.get(number)+1);
	    } else {
	        map.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	        int i = entry.getKey();
	        int j = value - i;
	        if (i == j && entry.getValue()>1 || i!=j && map.containsKey(j)) {
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);


