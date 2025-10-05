

class CheckIfStringIsAPrefixOfArray {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for(String str : words) {
            sb.append(str);
            if (sb.length() > s.length()) {
                return false;
            }
            if (sb.length() == s.length() && sb.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
