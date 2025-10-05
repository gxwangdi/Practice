
Starts with an empty list, for every visiting element, add it to all existing lists.  

Space complexity n*1 + n*(n-1)*2 + n*(n-1)*(n-2)*3 + .....+1*n.   Would need to figure out.  看起来像个级数一时半会儿想不起来怎么处理来着～  

Time complexity  n + n*(n-1) + n*(n-1)*(n-2) + .....+ n .     

If there are elements with same value, use a set to filter out duplicate list when building level list.   

