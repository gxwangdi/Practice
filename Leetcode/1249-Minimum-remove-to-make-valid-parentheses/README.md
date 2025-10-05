
This requires not only to check if it is valid, and need to trace which one to remove, then need to mark down the index of the chars that make it invalid.

Note that to use stack mark the '(', use set to mark ')'  

DO NOT build the res during the process, build the result at the end when all ToBeRemoveds aggregated into a set. That would make the impl easier.

 
