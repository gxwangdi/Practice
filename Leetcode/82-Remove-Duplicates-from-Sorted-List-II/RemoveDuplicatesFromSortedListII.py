# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        dummy = ListNode(0)
        dummy.next = head
        cur = dummy
        isDup = False
        while cur is not None and cur.next is not None:
            if cur.next.next is not None and cur.next.val == cur.next.next.val:
                isDup = True
                cur.next.next = cur.next.next.next
            else :
                if isDup:
                    isDup = False
                    cur.next = cur.next.next
                else:
                    cur = cur.next
        return dummy.next
    
