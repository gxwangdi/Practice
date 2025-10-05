# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(0)
        while head:
            temp = head
            head = head.next
            temp.next = None
            n = dummy
            while n.next:
                if temp.val < n.next.val:
                    break
                n = n.next
            temp.next = n.next
            n.next = temp
        return dummy.next
