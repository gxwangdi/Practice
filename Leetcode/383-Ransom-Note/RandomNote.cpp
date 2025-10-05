class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int count[26] = {0};
        for (int i=0; i<magazine.length(); i++) {
            int index = magazine.at(i)-'a';
            count[index]++;
        }
        for (int i=0; i<ransomNote.length(); i++) {
            int index = ransomNote.at(i)-'a';
            count[index]--;
            if (count[index]<0){
                return false;
            }
        }
        return true;
    }
};
