

class Removealladjacentduplicatesinstring {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (sb.length()!=0 && c == sb.charAt(sb.length()-1)) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
