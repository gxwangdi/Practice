# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return
        a, b = self._splitList(head)
        b = self._reverseList(b)
        head = self._mergeLists(a, b)

    def _splitList(self, head):
        fast = head
        slow = head
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next

        middle = slow.next
        slow.next = None
        return head, middle

    def _reverseList(self, head):
        last = None
        curNode = head
        while curNode:
            nextNode = curNode.next
            curNode.next = last
            last = curNode
            curNode = nextNode
        return last

    def _mergeLists(self, a, b):
        tail = a
        head = a
        a = a.next
        while b:
            tail.next = b
            tail = tail.next
            b = b.next
            if a:
                a, b = b, a
        return head
        
