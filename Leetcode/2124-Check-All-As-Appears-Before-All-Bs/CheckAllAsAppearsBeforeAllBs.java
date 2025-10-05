
class CheckAllAsAppearsBeforeAllBs {
    public boolean checkString(String s) {
        boolean meetB = false;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                if (meetB) {
                    return false;
                }
            } else { //c == 'b'
                meetB = true;
            }
        }
        return true;
    }
}
