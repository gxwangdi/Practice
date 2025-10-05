
class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        while(i<name.length() && j<typed.length())
        {
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
                continue;
            }
            if(i>0 && name.charAt(i-1) == typed.charAt(j)) {
                j++;
                continue;
            }
            return false;
        }

        if(i!=name.length()) {
            return false;
        }

        while(j<typed.length())
        {
            if(typed.charAt(j) != name.charAt(i-1)) {
                return false;
            }
            j++;
        }
        return true;
    }
}
