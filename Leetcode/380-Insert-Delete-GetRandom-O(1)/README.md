
We prepare two maps, one is m1 <V, K>, V is the one interact on the interface, K is maintained by an internal counter, which starts on 0.    

Another is m2 <K, V>. Both are hashmap to make sure the insert remove operations are in O(1).   

When inserting, check m1 if the value is available, if it is , return false; or insert <v, counter> to m1, <counter, v> to m2, counter++.  

When deleting, check m1 if the value exists, if it is not, return false; or get the k, and remove <v, k> from m1, remove <k, v> from m2,  take counter-1 from m2 and put it into k,  update m1 accordingly.  counter--.   

When get random, run Math.rand() and map it to 0~counter-1 space, and take V from m2.   

