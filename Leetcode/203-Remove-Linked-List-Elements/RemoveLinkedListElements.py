# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
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

        
