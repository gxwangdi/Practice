# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head == None or head.next == None:
            return head
        dummy = ListNode(0)
        dummy.next = head
        A = head
        head = A.next
        while A!=None :
            B = A.next
            if B == None:
                break;
            A.next = B.next
            B.next = A
            dummy.next = B
            dummy = A
            A = A.next
        return head

        
