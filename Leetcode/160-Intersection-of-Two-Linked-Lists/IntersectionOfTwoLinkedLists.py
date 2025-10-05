# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if headA == None or headB == None:
            return None
        
        a = headA
        b = headB
        while a!=b :
            if a==None:
                a = headB
            else:
                a = a.next
            if b==None:
                b = headA
            else:
                b = b.next
        return a
