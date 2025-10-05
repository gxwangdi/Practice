# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if not head or not head.next:
            return head
        len = self._getLength(head)
        k = k%len
        if k==0:
            return head
        dummy = ListNode(0)
        dummy.next = head
        fast = dummy
        while k>0:
            fast = fast.next
            k-=1
        slow = dummy
        while fast.next:
            slow = slow.next
            fast = fast.next
        dummy.next = slow.next
        slow.next = None
        fast.next = head
        return dummy.next

    def _getLength(self, head: ListNode) -> ListNode:
        cur = head
        len = 0
        while cur:
            cur = cur.next
            len+=1
        return len

        
