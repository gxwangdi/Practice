
For O(1) insert or move, think of HashSet or HashMap.   

GetRandom O(1), well,   Prepare two Map
<V, K>
<K, V>  and a pointer pointing to current available slot, or the size of the the  map, well, then we do not need to setup another pointer, just read the size of one map can work.  

For insert:
insert <V, K> with V for the element, K for the current map size, and insert <K, V>. 
For getRandom:
getRandom generates a random number first, and get the key, access <K,V> map for the V and return. 
For delete:

delete the entry of <V,K> using V, and reserve K as K1.  
if K == size, delete entry in <K,V> directly.   
else
get size-1 as K2,  access <K, V>  to get V2, update <V2, K2> as <V2, K1>, update <K1, V1> as <K1, V2>, delete <K2, V2>. 

