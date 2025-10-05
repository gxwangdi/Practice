
This looks like a search problem.   

For valid IP, it should be four level, each one is separated by '.', and each number should be 0~255.    

Just check the number, when it is valid 0~255, proceed to the next level, after level 4, if cursor reaches the end of the string, persist the result.   

Well, it looks like 010 is illegal, so when the cur pos is '0', it should be only one digit for this level.  
And pay attention to the exit strategy, not only cur but also level !    




