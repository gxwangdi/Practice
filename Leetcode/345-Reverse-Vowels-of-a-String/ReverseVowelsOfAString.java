import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s==null || s.length()<2)
            return s;
        
        char[] arr = s.toCharArray();
        int i=0;
        int j=arr.length-1;
        
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('I');
        set.add('i');
        set.add('o');
        set.add('O');
        set.add('U');
        set.add('u');
        while (i<j) {
            while (!set.contains(arr[i]) && i<j) {
                i++;
            }
            while (!set.contains(arr[j]) && i<j) {
                j--;
            }
            if (i==j)
                break;
            swap(arr, i, j);
            i++;
            j--;
        }
        String result = new String(arr);
        return result;
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}