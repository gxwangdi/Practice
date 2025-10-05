import java.util.ArrayList;


public class LongestWords {
	/**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> res = new ArrayList<>();
        if (dictionary == null || dictionary.length == 0) {
            return res;
        }
        int max = Integer.MIN_VALUE;
        for (String s : dictionary) {
            if (s.length() == max) {
                res.add(s);
                continue;
            }
            if (s.length() > max) {
                res.clear();
                res.add(s);
                max = s.length();
            }
        }
        return res;
    }
}
