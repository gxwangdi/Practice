# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:
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
