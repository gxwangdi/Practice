
Basically we can use an int array to record the frequency of all chars.   

When one char appears in magazine, the corresponding counter plus one, when in ransomNote, the corresponding counter minus one.  

If there is one counter turns out to be negative, return false.

Otherwise return true.  

Space O(1),  Time O(m+n).   

