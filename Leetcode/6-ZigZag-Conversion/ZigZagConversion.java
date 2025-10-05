public class ZigZagConversion {
    public String convert(String s, int numRows) {
    // Assume s is not null. 
        if (s.length() <= numRows || numRows <2)
            return s;

        StringBuilder sb = new StringBuilder(s.length());
        int size = 2*numRows -2;

        for (int i = 0; i < numRows; i++) {
            for (int j=i; j<s.length(); j+=size) {
                sb.append(s.charAt(j));
                if (i!=0 && i!= numRows-1) {
                    // first one and last one has only one presence in one cycle.
                    int temp = j+size-2*i;
                    if (temp < s.length())
                        sb.append(s.charAt(temp));
                }
            }
        }
        return sb.toString();
    }
}
