public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        reverse(s, 0, s.length-1);
        int begin = 0;
        int end = 0;
        while (end < s.length) {
            while (begin < s.length-1 && s[begin] == ' ') {
                begin++;
            }
            if (begin == s.length) {
                break;
            }
            end = begin;
            while (end < s.length && s[end] != ' ') {
                end++;
            }
            end--;
            reverse(s, begin, end);
            begin = end+1;
        }
    }// end of reverseWords
    
    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
    }// end of reverse             
}




