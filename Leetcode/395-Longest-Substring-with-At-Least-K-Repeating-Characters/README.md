
This is pretty much like the longest substring with at most k chars or something.    

I think the only difference is that,  how to adjust sliding window, when to move i and when to move j.       

scan char array from left to right
if we get a new character, count++, if a character already has nums k. count--
if we get a substring is satisfied with the question, and the start pos from 0, we change next loop's start pos from i+1 to end+1
loop   


