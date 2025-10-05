
class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char [] arr = s.toCharArray();
        int i =  0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)>=65 && s.charAt(i)<=90 || s.charAt(i)>=97 && s.charAt(i)<=122){
                while(!(s.charAt(j)>=65 && s.charAt(j)<=90 || s.charAt(j)>=97 && s.charAt(j)<=122)){
                    j--;
                }
                char c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
                j--;
                i++;
            }else{
                i++;
            }
        }
        return String.valueOf(arr);
    }
}
