

class LongestPalindromeByConcatenatingTwoLetterWords {
public int longestPalindrome(String[] words) {
    Map<String, Integer> count = new HashMap<>();

    for (String word: words) {
        count.put(word, count.getOrDefault(word, 0) + 1);
    }

    int ans = 0;
    boolean centerFound = false;
    for (String word: count.keySet()) {
        if (!sameLetters(word)) {
            ans += Math.min(count.get(word), count.getOrDefault(reverse(word), 0));
        }
        else if (count.get(word) % 2 == 1) {
            ans += count.get(word) - 1;
            centerFound = true;
        }
        else {
            ans += count.get(word);
        }
    }
    ans += centerFound ? 1 : 0;
    ans *= 2;

    return ans;

}

    private static boolean sameLetters(String word) {
    return word.charAt(0) == word.charAt(1);
}

private static String reverse(String word) {
    return "" + word.charAt(1) + word.charAt(0);
}
}
