/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

class Reader4 {
	int read4(char[] buf) {
		return 4;
	}
}

public class ReadNCharactersGivenRead4 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        for (int i=0; i<n; i+=4) {
            int len = read4(tmp);
            System.arraycopy(tmp, 0, buf, i, Math.min(len, n-i));
            if(len < 4) {
                return Math.min(i + len, n);
            }
        }
        return n;
    }
    
    /*
    public int read(char[] buf, int n) {
        int cur = 0;
        char[] temp = new char[4];
        while (cur < n) {
            int len = read4(temp);
            int i=0;
            while (i<len && cur<n) {
                buf[cur++] = temp[i++];
            }
            if (len < 4) {
                break;
            }
        }
        return cur;
    }
    */
}




