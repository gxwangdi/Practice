# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        cur = head

        leftDummy = ListNode(0)
        leftCur = leftDummy

        rightDummy = ListNode(0)
        rightCur = rightDummy

        while cur:
            if cur.val<x:
                leftCur.next = cur
                cur=cur.next
                leftCur=leftCur.next
                leftCur.enxt = None
            else:
                rightCur.next = cur
                cur = cur.next
                rightCur = rightCur.next
                rightCur.next = None
        leftCur.next = rightDummy.next
        return leftDummy.next
    
