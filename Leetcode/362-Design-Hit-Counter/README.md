
only one integer that matters, would think of set, and it asks for range query, would probably think of tree set. 

For unlimited space, maybe we can use a map<time, count>, and get a time stamp i, starting from i-300+1, to check if there is a record in the map.   

This assumes that frequent hits in every second, if it is rare hits, then treemap could be a better choice.  

Or if it is hard code to be last 5 minute,  we might want to use cyclic array, like 300 slots.   but it needs to manage the last position.   



