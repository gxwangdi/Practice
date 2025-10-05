
Shortest distance, it sounds like BFS.   

We will need to use a set to record all the points/words we visited,   and replace any single one char at any single place starting from a word in the queue, to find the next word/adjacent point.   

DO NOT push forward for position, like pass in a int cur for recursive approach.  

