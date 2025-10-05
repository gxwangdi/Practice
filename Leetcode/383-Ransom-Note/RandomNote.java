public class RandomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i=0; i<magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            count[index]++;
        }
        for (int i=0; i<ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            count[index]--;
            if (count[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
