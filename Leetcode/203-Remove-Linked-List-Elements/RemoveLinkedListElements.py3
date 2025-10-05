# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        if not head:
            return head
        dummy = ListNode(0)
        dummy.next = head
        cur = dummy
        while cur:
            ite = cur.next
            exists = False
            while ite and ite.val == val:
                exists = True
                ite = ite.next
            if exists:
                cur.next = ite
            cur = ite
        return dummy.next

        
