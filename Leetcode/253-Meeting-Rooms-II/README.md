
I would sort all intervals based on start time, end time.   
And insert into lists that top element does not have conflicts with cur element.
Check how many lists are there at the end.  

there is an algorithm called sweep line,  would need to check that and come back to this problem.   

Note, when we write the comparator, need to sort based on the time, if time equals, then exit pair should be put first!    Set the plusOne as int and 1 for start, -1 for exit for implementation simplicity.   


Pay attention to the comparator lambda.
