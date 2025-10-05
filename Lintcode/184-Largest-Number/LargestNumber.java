import java.util.Arrays;
import java.util.Comparator;


public class LargestNumber {
	/**
     *@param num: A list of non negative integers
     *@return: A string
     */
	public String largestNumber(int[] num) {
		if (num == null || num.length == 0) {
			return "";
		}
		String[] ob = new String[num.length];
		for (int i = 0; i < num.length; i++) {
			ob[i] = num[i] + "";
		}
		Arrays.sort(ob, numberComparator);
		StringBuilder sb = new StringBuilder();
		int cur = 0;
		while (cur < ob.length && "0".equals(ob[cur])) {
			cur++;
		}
		while (cur < ob.length) {
			sb.append(ob[cur]);
			cur++;
		}
		if (sb.length() == 0) {
			sb.append(0);
		}
		return sb.toString();
	}

	private Comparator<String> numberComparator = new Comparator<String>() {
		public int compare(String s1, String s2) {
			return (s2 + s1).compareTo(s1 + s2);
		}
	};
    
    /*
    private Comparator<Integer> digitComparator = new Comparator<Integer>(){
        public int compare(Integer i1, Integer i2) {
            String s1 = i1+"";
            String s2 = i2+"";
            long v1 = 0;
            long v2 = 0;
            int cur1 = 0;
            int cur2 = 0;
            while (cur1<s1.length() || cur2<s2.length()) {
                if (cur1 < s1.length()) {
                    v1 = v1*10 + s1.charAt(cur1)-'0';
                    cur1++;
                } else {
                    v1 *= 10;
                }
                if (cur2 < s2.length()) {
                    v2 = v2*10 + s2.charAt(cur2)-'0';
                    cur2++;
                } else {
                    v2 *= 10;
                }
            }
            if (v2 > v1) {
                return 1;
            } else if (v2 == v1) {
                return 0;
            } else {
                return -1;
            }
        }
    };
    */
}
