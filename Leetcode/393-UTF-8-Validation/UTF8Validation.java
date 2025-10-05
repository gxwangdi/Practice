public class UTF8Validation {
    
    public boolean validUtf8(int[] data) {
        int index = 0;
        while (index < data.length) {
            int after = 0;
            if ((data[index] & 0xFFFFFF80) == 0) {
            } else if ((data[index] & 0xffffffe0) == 0x000000c0) {
                after = 1;
            } else if ((data[index] & 0xfffffff0) == 0x000000e0) {
                after = 2;
            } else if ((data[index] & 0xfffffff8) == 0x000000f0) {
                after = 3;
            } else {
                return false;
            }
            after += index;
            if (after >= data.length) return false;
            while (++index <= after) {
                if ((data[index] & 0xffffffc0) != 0x00000080) return false;
            }
        }
        return true;
    }// end of validUtf8      
    
}






