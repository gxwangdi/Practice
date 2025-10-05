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
        if head == None or head.next == None:
            return head
        
        cur = head;
        while cur != None and cur.next != None:
            nextVal = cur.next
            while nextVal != None and nextVal.val == cur.val :
                nextVal = nextVal.next
            cur.next = nextVal
            cur = cur.next
        return head
        
