# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if head == None or n<=m :
            return head
        
        dummy = ListNode(0)
        dummy.next = head
        cur = dummy
        i = 0;
        while i+1 < m:
            if cur != None :
                cur = cur.next
            i+=1
        prev = cur
        n1 = None
        if prev != None :
            n1 = prev.next
        n2 = None
        if n1 != None :
            n2 = n1.next
        ran = n-m
        while ran >0 and n2!=None :
            n2.next, n1, n2 = n1, n2, n2.next
            ran-=1
        
        if prev!=None and prev.next!=None :
            prev.next.next = n2
            prev.next = n1
        return dummy.next;

