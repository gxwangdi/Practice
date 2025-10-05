
Using BFS to build the whole graph, and use map<word, distance> to store the shortest distance from beginning to here.   

After the map is built, using DFS starting from the end word, moves towards the start. 
For the DFS, I will need to build a map<to, from> when doing BFS.  

Get the routine and reverse before delivering.    

 