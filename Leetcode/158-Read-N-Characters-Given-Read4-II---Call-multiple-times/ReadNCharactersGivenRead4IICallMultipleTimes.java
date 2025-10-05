import java.util.LinkedList;
import java.util.Queue;

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class ReadNCharactersGivenRead4IICallMultipleTimes extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n <= 0) {
            return 0;
        }
        int total = 0;
        char[] temp = new char[4];
        while (this.buffer.size() < n && !isEOF) {
            int r = read4(temp);
            if (r < 4) {
                isEOF = true;
            }
            for (int i=0; i<r; i++) {
                this.buffer.offer(temp[i]);
            }
        }
        
        int len = Math.min(n, this.buffer.size());
        for (int i=0; i<len; i++) {
            buf[i] = this.buffer.poll();
            total++;
        }
        return total;
    }
    
    private boolean isEOF = false;
    private Queue<Character> buffer = new LinkedList<>();
}



