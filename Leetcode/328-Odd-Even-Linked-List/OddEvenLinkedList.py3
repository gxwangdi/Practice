# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if head == None:
            return head

        o = head
        e = head.next
        eHead = head.next
        while e != None and e.next != None:
            o.next = e.next
            e.next = e.next.next
            o = o.next
            e = e.next

        o.next = eHead
        return head

    
