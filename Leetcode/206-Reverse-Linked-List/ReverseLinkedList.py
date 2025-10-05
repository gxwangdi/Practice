# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None :
            return head
        
        n1 = head
        n2 = n1.next;
        n1.next = None
        while n2 != None :
            n2.next, n1, n2= n1, n2, n2.next
        
        return n1
