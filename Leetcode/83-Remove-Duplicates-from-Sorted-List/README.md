
Two pointers, cur and nextVal.  Cur starts from head, when cur.next.val == cur.val, use nextVal to proceed to find the next value, and replace cur.next, then cur starts from nextVal, until cur.next == null.   

Space O(1), Time O(n).  