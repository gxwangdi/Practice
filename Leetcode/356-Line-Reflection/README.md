
reflect....  Well, the problem is, given a set of points, which could contain duplicate points,  check to see if there is a line parallel to Y-axi, that splits all the points into two half which are mirror centric.   

find the max and min on x, and the line must be y = (min+max)/2;  Pay attention that the result is integer, so a point m and its corresponding point n should  satisfy m.x+n.x=min+max,  m.y=n.y.    

Duplicate points are treated as one point, so use e a set for duplicate points.  

Time O(n), Space O(n).   

 

