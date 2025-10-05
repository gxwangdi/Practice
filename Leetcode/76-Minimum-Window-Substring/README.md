
Basically we treat target as a alphabet and no duplicate characters. we will need to do a pre-processing to speedup the match process.

Use a map to record the sliding window, if all value are above 0, then it is good!

Everytime the sliding window is good, check current length fast-slow+1, if it is smaller than min, update min and res[2] array for the start and end index of the substring.

The answer is source.substring(res[0], res[1]+1);

Space O(target.size()), Time O(source.size()).

Note that if target is like "acc", then in source substring, c must occur twice! Talk to interviewer to make sure this!
