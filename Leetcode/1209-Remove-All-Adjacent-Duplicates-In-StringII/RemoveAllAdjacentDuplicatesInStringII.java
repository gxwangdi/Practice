

class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        final int N = s.length();
        int[] count = new int[N];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            char c = s.charAt(i);
            sb.append(c);
            int last = sb.length()-1;
            if (last > 0 && sb.charAt(last) == sb.charAt(last-1)) {
                count[last] = 1 + count[last-1];
            } else {
                count[last] = 1;
            }
            if(count[last] == k) {
                sb.setLength(sb.length()-k);
            }
        }
        return sb.toString();
    }
}
