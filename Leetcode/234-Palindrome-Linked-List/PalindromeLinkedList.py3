# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head == None or head.next == None:
            return True

        slow = head
        fast = head
        while fast.next != None and fast.next.next!=None :
            slow = slow.next
            fast = fast.next.next
        sHead = slow.next
        slow.next = None

        # reverse sHead list
        p1 = sHead
        p2 = p1.next
        while p1 != None and p2!=None :
            p2.next, p1, p2 = p1, p2, p2.next
        sHead.next = None

        # compare head and sHead
        p = p2
        if p2 == None:
            p = p1
        q = head
        while p != None:
            if p.val != q.val:
                return False
            p = p.next
            q = q.next
        return True

        
